package chuggaChugga.service;

import chuggaChugga.data.TrainRequest;
import chuggaChugga.data.TrainRoute;
import chuggaChugga.data.TrainTimetable;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.domain.TrainDataSet;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import java.util.ArrayList;

public interface TrainService {
    TrainTimetable getTrains(TrainRequest trainRequest);
    LocalTime trainPassStation(TrainDto train, StationDataSet arrivalStation);
    ArrayList<TrainDto> getAllTrains();
    void createTrain(TrainRoute trainRoute);
    void updateTrain(TrainDataSet train);
    TrainDataSet getTrain(int id);
    ArrayList<UserDto> getPassengers(int trainId);
    LocalDateTime getArrivalDateTime(TrainDto train, StationDataSet station);
    LocalDateTime getDepartureDateTime(TrainDto train, StationDataSet station);
    TrainDto getEarliestTrain(StationDataSet departureStation, StationDataSet arrivalStation, LocalDateTime dateTime);
    ArrayList<TrainDto> getAllTrainsWhichPassStation(StationDataSet station);
}
