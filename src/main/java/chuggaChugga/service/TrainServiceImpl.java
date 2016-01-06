package chuggaChugga.service;

import chuggaChugga.dao.TrainDao;
import chuggaChugga.data.*;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.*;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


/*
*  Implements logic connected to trains
*
* */

@Service
@Transactional
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private StationService stationService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private TicketService ticketService;

    /*
    * Using for finding trains, that depart from selected station at selected day, and arrival to another selected station
    *
    * @param Two stations and date
    *
    * @return All the required train
    *
    * */
    public TrainTimetable getTrains(TrainRequest trainRequest) {
        //ToDo get by id, maybe?
        StationDataSet departureStation = stationService.getStationByName(trainRequest.getDepartureStation());
        StationDataSet arrivalStation = stationService.getStationByName(trainRequest.getArrivalStation());
        TrainTimetable.Builder resultBuilder = TrainTimetable.newBuilder()
                .withArrivalStation(arrivalStation)
                .withDepartureStation(departureStation)
                .withDepartureDate(trainRequest.getDate());


        ArrayList<TrainRouteTime> times = new ArrayList<TrainRouteTime>();
        ArrayList<TrainArrivalTime> trainsArrivedOnFirstStation = stationService.getTimetable(departureStation, trainRequest.getDate()).getTrainArrivalTimes();
        for (TrainArrivalTime trainArrivalTime: trainsArrivedOnFirstStation) {
            LocalTime timeTrainPassStation = trainPassStation(trainArrivalTime.getTrain(), arrivalStation);
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
    *  @param TrainDataSet and station
    *
    *  @return Date
    *
    * */
    public LocalTime trainPassStation(TrainDataSet train, StationDataSet arrivalStation) {
        int routeId = train.getDepartureStation().getRouteId();
        ArrayList<Route> allRoutes = routeService.getAllRoutes();
        for (Route route: allRoutes) {
            if (route.getRouteId() == routeId) {
                for (RouteStationDataSet station: route.getRouteStations()){
                    if (station.getStation().equals(arrivalStation)) {
                        return new LocalTime(station.getArrival());
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<TrainDataSet> getAllTrains() {
        return (ArrayList<TrainDataSet>) trainDao.getAllTrains();
    }

    public void createTrain(TrainRoute trainRoute) {
        trainDao.addTrain(trainRoute.getTrain());

        TrainDataSet trainWithId = TrainDataSet.newBuilder(trainRoute.getTrain()).withId(trainDao.getTrainTableSize()).build();

        for (RouteStationDataSet routeStation : trainRoute.getRoute().getRouteStations()) {
            TimetableDataSet.Builder timetableBuilder = TimetableDataSet.newBuilder();
            timetableBuilder.withTrain(trainWithId).withRouteStation(routeStation);

            timetableService.addTimetable(timetableBuilder.build());
        }
    }

    public TrainDataSet getTrain(int id) {
        return trainDao.getTrain(id);
    }

    public ArrayList<UserDto> getPassangers(int trainId) {

        ArrayList<TicketDataSet> tickets = ticketService.getTicketByTrain(trainDao.getTrain(trainId));
        ArrayList<UserDto> result = new ArrayList<UserDto>();
        for (TicketDataSet ticket: tickets) {
            result.add(new UserDto(ticket.getUser()));
        }
        return result;
    }
}
