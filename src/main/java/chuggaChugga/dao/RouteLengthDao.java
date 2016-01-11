package chuggaChugga.dao;

import chuggaChugga.domain.RouteLengthDataSet;

public interface RouteLengthDao {
    void addRouteLength(RouteLengthDataSet routeLength);
    int getFreeRouteId();
}
