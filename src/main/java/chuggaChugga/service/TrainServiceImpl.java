package chuggaChugga.service;

import chuggaChugga.dao.TrainDao;
import chuggaChugga.data.*;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
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
    public LocalTime trainPassStation(TrainDto train, StationDataSet arrivalStation) {
        for (RouteStationDataSet station: train.getRoute().getRouteStations()){
            if (station.getStation().equals(arrivalStation)) {
                return new LocalTime(station.getArrival());
            }
        }
        return null;
    }

    public ArrayList<TrainDto> getAllTrains() {
        ArrayList<TrainDto> result = new ArrayList<>();
        for (TrainDataSet train: trainDao.getAllTrains()) {
            result.add(new TrainDto(train, routeService.getRouteById(train.getArrivalStation().getRouteId())));
        }
        return result ;
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

    @Override
    public void updateTrain(TrainDataSet train) {
        trainDao.updateTrain(train);
    }

    public TrainDataSet getTrain(int id) {
        return trainDao.getTrain(id);
    }

    public ArrayList<UserDto> getPassengers(int trainId) {
        ArrayList<TicketDataSet> tickets = ticketService.getTicketByTrain(trainDao.getTrain(trainId));
        ArrayList<UserDto> result = new ArrayList<UserDto>();
        for (TicketDataSet ticket: tickets) {
            result.add(UserDto.newBuilder(ticket.getUser()).build());
        }
        return result;
    }

    @Override
    public LocalDateTime getArrivalDateTime(TrainDto train, StationDataSet station) {
        //todo: mark as nullable
        if (train == null || station == null) {
            return null;
        }

        Route route = train.getRoute();
        if (route.getStations().contains(station)) {
            for (RouteStationDataSet routeStationDataSet: route.getRouteStations()) {
                if (routeStationDataSet.getStation().equals(station)) {
                    LocalTime arrivalTime = new LocalTime(routeStationDataSet.getArrival());
                    LocalDate arrivalDate = new LocalDate(train.getDepartureDate()).plusDays(routeStationDataSet.getDayCount());
                    return new LocalDateTime(arrivalDate.getYear(), arrivalDate.getMonthOfYear(), arrivalDate.getDayOfMonth(),
                            arrivalTime.getHourOfDay(), arrivalTime.getMinuteOfHour(), arrivalTime.getSecondOfMinute());
                }
            }
        }
        return null;
    }

    @Override
    public LocalDateTime getDepartureDateTime(TrainDto train, StationDataSet station) {
        //todo: mark as nullable
        if (train == null || station == null) {
            return null;
        }

        Route route = train.getRoute();
        if (route.getStations().contains(station)) {
            for (RouteStationDataSet routeStationDataSet: route.getRouteStations()) {
                if (routeStationDataSet.getStation().equals(station)) {
                    LocalTime waitingTime = new LocalTime(routeStationDataSet.getWaitingTime());
                    LocalTime departureTime = new LocalTime(routeStationDataSet.getArrival())
                            .plusHours(waitingTime.getHourOfDay())
                            .plusMinutes(waitingTime.getMinuteOfHour())
                            .plusSeconds(waitingTime.getSecondOfMinute());
                    LocalDate departureDate = new LocalDate(train.getDepartureDate()).plusDays(routeStationDataSet.getDayCount());
                    return new LocalDateTime(departureDate.getYear(), departureDate.getMonthOfYear(), departureDate.getDayOfMonth(),
                            departureTime.getHourOfDay(), departureTime.getMinuteOfHour(), departureTime.getSecondOfMinute());
                }
            }
        }
        return null;
    }

    public ArrayList<TrainDto> getAllTrainsWhichPassStation(StationDataSet station) {
        ArrayList<TrainDto> result = new ArrayList<>();
        for (TrainDataSet train: trainDao.getAllTrainsWhichPassStation(station)) {
            result.add(new TrainDto(train, routeService.getRouteById(train.getArrivalStation().getRouteId())));
        }
        return result;
    }

    @Override
    public TrainDto getEarliestTrain(StationDataSet departureStation, StationDataSet arrivalStation, LocalDateTime dateTime) {
        ArrayList<TrainDto> trains = getAllTrainsWhichPassStation(departureStation);
        TrainDto result = null;
        LocalDateTime currentDateTime = null;
        for (TrainDto train: trains) {
            ArrayList<StationDataSet> stations = train.getRoute().getStations();
            if (stations.contains(arrivalStation)) {
                int departureIndex = stations.indexOf(departureStation);
                int arrivalIndex = stations.indexOf(arrivalStation);
                if (departureIndex < arrivalIndex) {
                    LocalDateTime departureTime = getArrivalDateTime(train, departureStation);
                    if (dateTime.isBefore(departureTime)) {
                        if (result == null || departureTime.isBefore(currentDateTime)) {
                            result = train;
                            currentDateTime = departureTime;
                        }
                    }
                }
            }
        }
        return result;
    }
}
