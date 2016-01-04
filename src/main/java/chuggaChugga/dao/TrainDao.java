package chuggaChugga.dao;

import chuggaChugga.model.Train;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainDao {
    void addTrain(Train train);
    int getTrainTableSize();
    List<Train> getAllTrains();
    Train getTrain(int id);
}
