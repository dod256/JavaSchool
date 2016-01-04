package chuggaChugga.dao;

import chuggaChugga.model.Station;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface StationDao {
    void addStation(Station station);
    Station getStation(String name);
    List<Station> getAllStations();
}
