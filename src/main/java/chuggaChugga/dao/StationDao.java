package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;

import java.util.List;


public interface StationDao {
    void addStation(StationDataSet station);
    StationDataSet getStationByName(String name);
    StationDataSet getStation(int id);
    List<StationDataSet> getAllStations();
}
