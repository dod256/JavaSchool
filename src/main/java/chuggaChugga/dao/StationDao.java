package chuggaChugga.dao;

import chuggaChugga.model.StationDataSet;

import java.util.List;


public interface StationDao {
    void addStation(StationDataSet station);
    StationDataSet getStation(String name);
    List<StationDataSet> getAllStations();
}
