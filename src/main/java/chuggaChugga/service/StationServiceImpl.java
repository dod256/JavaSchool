package chuggaChugga.service;

import chuggaChugga.dao.StationDao;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.model.RouteStationDataSet;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;
import chuggaChugga.data.Route;
import chuggaChugga.data.StationTimetable;
import chuggaChugga.data.TrainArrivalTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        System.out.println(trainService.getAllTrains());
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

    @Override
    public ArrayList<StationDataSet> getAllStationsOrderedById() {
        ArrayList<StationDataSet> sortedById = getAllStations();
        Collections.sort(sortedById, (o1, o2) -> o1.getId() - o2.getId());
        return sortedById;
    }

    @Override
    public ArrayList<StationDataSet> getAllStationsOrderdByName() {
        ArrayList<StationDataSet> sortedByName = getAllStations();
        Collections.sort(sortedByName, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return sortedByName;
    }

    /*
    *  Find all trains that arrival in selected day to selected station
    *
    * @param StationDataSet and date
    *
    * @return List of train with arrival time
    *
    * */
    public StationTimetable getTimetable(StationDataSet station, LocalDate transitDate) {
        StationTimetable.Builder timetableBuilder = StationTimetable.newBuilder();
        ArrayList<TrainArrivalTime> trainArrivalTime = new ArrayList<>();
        ArrayList<TrainDto> trains = trainService.getAllTrains();
        for (TrainDto train : trains) {
            RouteStationDataSet departureStation = train.getDepartureRouteStation();
            LocalDate departureDate = new LocalDate(train.getDepartureDate());
            if (departureStation.getStation().equals(station) && departureDate.equals(transitDate)) {
                trainArrivalTime.add(
                        TrainArrivalTime.newBuilder()
                                .withArrivalTime(new LocalTime(departureStation.getArrival()))
                                .withTrain(train).build());
            } else {
                Route route = train.getRoute();
                if (route.getStations().contains(station)) {
                    for (RouteStationDataSet routeStationOfCurrentRoute : route.getRouteStations()) {
                        if (routeStationOfCurrentRoute.getStation().equals(station)) {
                            LocalDate arrivalDate = departureDate.plusDays(routeStationOfCurrentRoute.getDayCount());
                            if (arrivalDate.equals(transitDate)) {
                                trainArrivalTime.add(TrainArrivalTime.newBuilder()
                                        .withTrain(train)
                                        .withArrivalTime(new LocalTime(routeStationOfCurrentRoute.getArrival()))
                                        .build());
                                break;
                            }
                        }
                    }
                }
            }
        }
        return timetableBuilder
                .withStation(station)
                .withDate(transitDate)
                .withTrainArrivalTimes(trainArrivalTime)
                .build();
    }

}