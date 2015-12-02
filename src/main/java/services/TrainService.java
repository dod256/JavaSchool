package main.java.services;

import main.java.Entities.RouteStation;
import main.java.Entities.Station;
import main.java.Entities.Timetable;
import main.java.Entities.Train;
import main.java.dao.TrainDao;
import main.java.data.*;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class TrainService extends Service {

    private static TrainDao trainDao = new TrainDao(em);

    public static TrainTimetable getTrains(TrainRequest trainRequest) {
        Station departureStation = StationService.getStation(trainRequest.getDepartureStation());
        Station arrivalStation = StationService.getStation(trainRequest.getArrivalStation());
        TrainTimetable.Builder resultBuilder = TrainTimetable.newBuilder()
                .withArrivalStation(arrivalStation)
                .withDepartureStation(departureStation)
                .withDepartureDate(trainRequest.getDate());


        ArrayList<TrainRouteTime> times = new ArrayList<TrainRouteTime>();
        ArrayList<TrainArrivalTime> trainsArrivedOnFirstStation = StationService.getTimetable(departureStation, trainRequest.getDate()).getTrainArrivalTimes();
        for (TrainArrivalTime trainArrivalTime: trainsArrivedOnFirstStation) {
            DateTime timeTrainPassStation = trainPassStation(trainArrivalTime.getTrain(), arrivalStation);
            if (timeTrainPassStation != null) {
                TrainRouteTime routeTime = TrainRouteTime.newBuilder()
                        .withTrain(trainArrivalTime.getTrain())
                        .withDepartureTime(trainArrivalTime.getArrivalTime())
                        .withArrivalTime(timeTrainPassStation).build();
                times.add(routeTime);
            }
        }

        return resultBuilder.withTrainRouteTimes(times).build();
    }

    private static DateTime trainPassStation(Train train, Station arrivalStation) {
        int routeId = train.getDepartureStation().getRouteId();
        ArrayList<Route> allRoutes = RouteService.getAllRoutes();
        for (Route route: allRoutes) {
            if (route.getRouteId() == routeId) {
                for (RouteStation station: route.getRouteStations()){
                    if (station.getStation().equals(arrivalStation)) {
                        return new DateTime(station.getArrival());
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<Train> getAllTrains() {
        return trainDao.getAllTrains();
    }

    public static void createTrain(TrainRoute trainRoute) {
        trainDao.addTrain(trainRoute.getTrain());

        Train trainWithId = Train.newBuilder(trainRoute.getTrain()).withId(trainDao.getTrainTableSize()).build();

        for (RouteStation routeStation : trainRoute.getRoute().getRouteStations()) {
            Timetable.Builder timetableBuilder = Timetable.newBuilder();
            timetableBuilder.withTrain(trainWithId).withRouteStation(routeStation);

            TimetableService.addTimetable(timetableBuilder.build());
        }
    }

    public static Train getTrain(int id) {
        return trainDao.getTrain(id);
    }




}
