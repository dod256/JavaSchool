package service;

import model.RouteStation;
import model.Station;
import model.Train;
import dao.StationDao;
import data.Route;
import data.StationTimetable;
import data.TrainArrivalTime;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;

/*
*  Implements logic connected to stations
*
* */
public class StationService extends Service {

    private static StationDao stationDao = new StationDao(em);

    public static void addStation(Station station) {
        stationDao.addStation(station);
    }
    public static Station getStation(String name) {
        return stationDao.getStation(name);
    }

    public static ArrayList<Station> getAllStations() {
        ArrayList<Station> result = stationDao.getAllStations();
        result.sort(new Comparator<Station>() {
            public int compare(Station o1, Station o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return result;
    }


    /*
    *  Find all trains that arrival in selected day to selected station
    *
    * @param Station and date
    *
    * @return List of train with arrival time
    *
    * */
    public static StationTimetable getTimetable(Station station, DateTime transitDate) {
        ArrayList<TrainArrivalTime> result = new ArrayList<TrainArrivalTime>();

        ArrayList<Train> trains = TrainService.getAllTrains();
        ArrayList<Route> routes = RouteService.getAllRoutes();
        for (Train train: trains) {
            RouteStation departureStation = train.getDepartureStation();
            DateTime departureDate = new DateTime(train.getDepartureDate().getTime());
            if (departureStation.getStation().equals(station) && departureDate.getYear() == transitDate.getYear() && departureDate.getDayOfYear() == transitDate.getDayOfYear()) {
                result.add(TrainArrivalTime.newBuilder()
                            .withArrivalTime(new DateTime(train.getDepartureDate().getTime()).plus(departureStation.getArrival().getTime()).plusHours(4)).withTrain(train).build());
            } else {
                departureDate = departureDate.plus(departureStation.getArrival().getTime());
                for (Route route: routes) {
                    if (route.getRouteId() == departureStation.getRouteId() && route.getStations().contains(station)) {
                        for (RouteStation routeStationOfCurrentRoute: route.getRouteStations()) {
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
