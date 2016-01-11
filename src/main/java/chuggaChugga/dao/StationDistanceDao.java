package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;
import chuggaChugga.domain.StationDistanceDataSet;
import java.util.ArrayList;

public interface StationDistanceDao {
    void addDistance(StationDistanceDataSet stationDistance);
    void updateDistance(StationDistanceDataSet stationDistance);
    StationDistanceDataSet findDistance(StationDataSet firstStation, StationDataSet secondStation);
    ArrayList<StationDistanceDataSet> findAllDistances(StationDataSet station);
}
