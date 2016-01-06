package chuggaChugga.service;

import chuggaChugga.data.NewRouteImpl;
import chuggaChugga.data.Route;
import chuggaChugga.data.RouteRequest;

import java.util.ArrayList;


public interface RouteService {
    void createRoute(NewRouteImpl newRoute);
    Route getRouteById(int routeId);
    ArrayList<Route> getAllRoutes();
    ArrayList<Route> getRoutes(RouteRequest request);
}
