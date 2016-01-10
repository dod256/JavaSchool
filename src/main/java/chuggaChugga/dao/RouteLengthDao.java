package chuggaChugga.dao;

import chuggaChugga.model.RouteLengthDataSet;

public interface RouteLengthDao {
    void addRouteLength(RouteLengthDataSet routeLength);
    int getFreeRouteId();
}
