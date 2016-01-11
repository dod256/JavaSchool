package chuggaChugga.dao;

import chuggaChugga.domain.RouteStationDataSet;

import java.util.List;


public interface RouteStationDao {
    List<RouteStationDataSet> getRouteStationsById(int routeId);
    List<RouteStationDataSet> getAllRouteStations();
    void addRouteStation(RouteStationDataSet station);
}
