package chuggaChugga.service;

import chuggaChugga.data.StationTimetable;
import chuggaChugga.model.Station;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface StationService {
    void addStation(Station station);
    Station getStation(String name);
    ArrayList<Station> getAllStations();
    StationTimetable getTimetable(Station station, DateTime transitDate);

}
