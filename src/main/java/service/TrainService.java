package service;

import model.*;
import dao.TrainDao;
import data.*;
import dto.UserDto;
import org.joda.time.DateTime;

import java.util.ArrayList;


/*
*  Implements logic connected to trains
*
* */
public class TrainService extends Service {

    private static TrainDao trainDao = new TrainDao(em);


    /*
    * Using for finding trains, that depart from selected station at selected day, and arrival to another selected station
    *
    * @param Two stations and date
    *
    * @return All the required train
    *
    * */
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

    /*
    *  Counting when selected train arrival at selected station
    *
    *  @param Train and station
    *
    *  @return Date
    *
    * */
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

    public static ArrayList<UserDto> getPassangers(int trainId) {
        ArrayList<Ticket> tickets = TicketService.getTicketByTrain(trainId);
        ArrayList<UserDto> result = new ArrayList<UserDto>();
        for (Ticket ticket: tickets) {
            result.add(new UserDto(ticket.getUser()));
        }
        return result;
    }
}
