package chuggaChugga.dao;

import chuggaChugga.model.RouteLengthDataSet;

import java.util.List;


public interface RouteLengthDao {
    void addRouteLength(RouteLengthDataSet routeLength);
    int getFreeRouteId();
}
