package chuggaChugga.service;

import chuggaChugga.dao.StationDao;
import chuggaChugga.model.RouteStationDataSet;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;
import chuggaChugga.data.Route;
import chuggaChugga.data.StationTimetable;
import chuggaChugga.data.TrainArrivalTime;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/*
*  Implements logic connected to stations
*
* */

@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;
    @Autowired
    private TrainService trainService;
    @Autowired
    private RouteService routeService;


    public void addStation(StationDataSet station) {
        stationDao.addStation(station);
    }

    public StationDataSet getStationByName(String name) {
        return stationDao.getStationByName(name);
    }

    public StationDataSet getStation(int id) {
        return stationDao.getStation(id);
    }

    public ArrayList<StationDataSet> getAllStations() {
        ArrayList<StationDataSet> result = (ArrayList<StationDataSet>) stationDao.getAllStations();
        result.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return result;
    }

    /*
    *  Find all trains that arrival in selected day to selected station
    *
    * @param StationDataSet and date
    *
    * @return List of train with arrival time
    *
    * */
    public StationTimetable getTimetable(StationDataSet station, DateTime transitDate) {
        ArrayList<TrainArrivalTime> result = new ArrayList<TrainArrivalTime>();

        ArrayList<TrainDataSet> trains = trainService.getAllTrains();
        ArrayList<Route> routes = routeService.getAllRoutes();
        for (TrainDataSet train: trains) {
            RouteStationDataSet departureStation = train.getDepartureStation();
            DateTime departureDate = new DateTime(train.getDepartureDate().getTime());
            if (departureStation.getStation().equals(station) && departureDate.getYear() == transitDate.getYear() && departureDate.getDayOfYear() == transitDate.getDayOfYear()) {
                result.add(TrainArrivalTime.newBuilder()
                            .withArrivalTime(new DateTime(train.getDepartureDate().getTime()).plus(departureStation.getArrival().getTime()).plusHours(4)).withTrain(train).build());
            } else {
                departureDate = departureDate.plus(departureStation.getArrival().getTime());
                for (Route route: routes) {
                    if (route.getRouteId() == departureStation.getRouteId() && route.getStations().contains(station)) {
                        for (RouteStationDataSet routeStationOfCurrentRoute: route.getRouteStations()) {
                            if (routeStationOfCurrentRoute.getStation().equals(station)) {
                                DateTime onWheel = new DateTime( routeStationOfCurrentRoute.getOnWheel().getTime());
                                departureDate = departureDate.plus(onWheel.getMillis());
                                departureDate = departureDate.plusHours(4);
                                if (departureDate.getYear() == transitDate.getYear() && departureDate.getDayOfYear() == transitDate.getDayOfYear()) {
                                    result.add(TrainArrivalTime.newBuilder()
                                            .withArrivalTime(new DateTime(routeStationOfCurrentRoute.getArrival())).withTrain(train).build());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return StationTimetable.newBuilder().withDate(transitDate).withStation(station).withTrainArrivalTimes(result).build();
    }

}
