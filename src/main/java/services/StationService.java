package main.java.services;


import main.java.Entities.RouteStation;
import main.java.Entities.Station;
import main.java.Entities.Train;
import main.java.dao.StationDao;
import main.java.data.Route;
import main.java.data.StationTimetable;
import main.java.data.TrainArrivalTime;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;

public class StationService extends Service {

    private static StationDao stationDao = new StationDao(em);

    public static void addStation(Station station) {
        stationDao.addStation(station);
    }
    public static Station getStation(String name) {
        return stationDao.getStation(name);
    }
    //todo: sort
    public static ArrayList<Station> getAllStations() {return stationDao.getAllStations();}


    public static StationTimetable getTimetable(Station station, DateTime transitDate) {
        ArrayList<TrainArrivalTime> result = new ArrayList<TrainArrivalTime>();

        ArrayList<Train> trains = TrainService.getAllTrains();
        ArrayList<Route> routes = RouteService.getAllRoutes();
        for (Train train: trains) {
            RouteStation departureStation = train.getDepartureStation();
            DateTime departureDate = new DateTime(train.getDepartureDate().getTime());
            if (departureStation.getStation().equals(station) && departureDate.getYear() == transitDate.getYear() && departureDate.getDayOfYear() == transitDate.getDayOfYear()) {
                result.add(TrainArrivalTime.newBuilder()
                            .withArrivalTime(new DateTime(train.getDepartureDate().getTime()).plus(departureStation.getArrival().getTime())).withTrain(train).build());
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
