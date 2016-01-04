package chuggaChugga.dao;

import chuggaChugga.model.RouteLength;
import java.util.List;


public interface RouteLengthDao {
    void addRouteLength(RouteLength routeLength);
    List<RouteLength> getAllRouteLength();
}
