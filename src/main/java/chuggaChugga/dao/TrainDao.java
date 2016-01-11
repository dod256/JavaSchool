package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;
import chuggaChugga.domain.TrainDataSet;

import java.util.List;


public interface TrainDao {
    void addTrain(TrainDataSet train);
    void updateTrain(TrainDataSet train);
    int getTrainTableSize();
    List<TrainDataSet> getAllTrains();
    List<TrainDataSet> getAllTrainsWhichPassStation(StationDataSet station);
    TrainDataSet getTrain(int id);
}
