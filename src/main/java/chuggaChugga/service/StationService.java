package chuggaChugga.service;

import chuggaChugga.data.StationTimetable;
import chuggaChugga.domain.StationDataSet;
import org.joda.time.LocalDate;

import java.util.ArrayList;


public interface StationService {
    void addStation(StationDataSet station);
    StationDataSet getStationByName(String name);
    StationDataSet getStation(int id);
    ArrayList<StationDataSet> getAllStations();
    ArrayList<StationDataSet> getAllStationsOrderedById();
    ArrayList<StationDataSet> getAllStationsOrderdByName();

    StationTimetable getTimetable(StationDataSet station, LocalDate transitDate);

}
