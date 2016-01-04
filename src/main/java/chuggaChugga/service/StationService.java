package chuggaChugga.service;

import chuggaChugga.data.StationTimetable;
import chuggaChugga.model.StationDataSet;
import org.joda.time.DateTime;

import java.util.ArrayList;


public interface StationService {
    void addStation(StationDataSet station);
    StationDataSet getStation(String name);
    ArrayList<StationDataSet> getAllStations();
    StationTimetable getTimetable(StationDataSet station, DateTime transitDate);

}
