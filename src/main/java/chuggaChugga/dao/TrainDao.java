package chuggaChugga.dao;

import chuggaChugga.model.TrainDataSet;

import java.util.List;


public interface TrainDao {
    void addTrain(TrainDataSet train);
    int getTrainTableSize();
    List<TrainDataSet> getAllTrains();
    TrainDataSet getTrain(int id);
}
