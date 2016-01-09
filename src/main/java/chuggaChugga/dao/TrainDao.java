package chuggaChugga.dao;

import chuggaChugga.model.StationDataSet;
import chuggaChugga.model.TrainDataSet;

import java.util.List;


public interface TrainDao {
    void addTrain(TrainDataSet train);
    int getTrainTableSize();
    List<TrainDataSet> getAllTrains();
    List<TrainDataSet> getAllTrainsWhichPassStation(StationDataSet station);
    TrainDataSet getTrain(int id);
}
