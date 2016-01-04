package chuggaChugga.service;

import chuggaChugga.data.TrainRequest;
import chuggaChugga.data.TrainRoute;
import chuggaChugga.data.TrainTimetable;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.Station;
import chuggaChugga.model.Train;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface TrainService {
    TrainTimetable getTrains(TrainRequest trainRequest);
    DateTime trainPassStation(Train train, Station arrivalStation);
    ArrayList<Train> getAllTrains();
    void createTrain(TrainRoute trainRoute);
    Train getTrain(int id);
    ArrayList<UserDto> getPassangers(int trainId);
}
