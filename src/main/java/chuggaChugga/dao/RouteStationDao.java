package chuggaChugga.dao;

import chuggaChugga.model.RouteStationDataSet;

import java.util.List;


public interface RouteStationDao {
    List<RouteStationDataSet> getRouteStationsById(int routeId);
    List<RouteStationDataSet> getAllRouteStations();
    void addRouteStation(RouteStationDataSet station);
}
