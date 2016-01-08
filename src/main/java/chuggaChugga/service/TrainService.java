package chuggaChugga.service;

import chuggaChugga.data.TrainRequest;
import chuggaChugga.data.TrainRoute;
import chuggaChugga.data.TrainTimetable;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.time.LocalDateTime;
import java.util.ArrayList;


public interface TrainService {
    TrainTimetable getTrains(TrainRequest trainRequest);
    LocalTime trainPassStation(TrainDataSet train, StationDataSet arrivalStation);
    ArrayList<TrainDataSet> getAllTrains();
    void createTrain(TrainRoute trainRoute);
    TrainDataSet getTrain(int id);
    ArrayList<UserDto> getPassengers(int trainId);
    DateTime getDateTime(TrainDto train, StationDataSet station);
    TrainDto getEarliestTrain(String departureStation, String arrivalStation, LocalDateTime dateTime);
}
