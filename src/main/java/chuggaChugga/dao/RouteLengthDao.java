package chuggaChugga.dao;

import chuggaChugga.model.RouteLength;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RouteLengthDao {
    void addRouteLength(RouteLength routeLength);
    List<RouteLength> getAllRouteLength();
}
