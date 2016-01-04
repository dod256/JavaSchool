package chuggaChugga.dao;

import chuggaChugga.model.RouteStation;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RouteStationDao {
    List<RouteStation> getRouteStationsById(int routeId);
    List<RouteStation> getAllRouteStations();
    void addRouteStation(RouteStation station);
}
