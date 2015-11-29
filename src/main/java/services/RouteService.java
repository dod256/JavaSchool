package main.java.services;

import main.java.Entities.RouteStation;
import main.java.Entities.Station;
import main.java.dao.RouteStationDao;
import main.java.data.Route;
import main.java.data.RouteRequest;

import java.util.ArrayList;
import java.util.Comparator;

public class RouteService extends Service {

    private static RouteStationDao routeStationDao = new RouteStationDao(em);

    public static Route getRouteById(int routeId) {
        Route.Builder builder = Route.newBuilder();
        builder.withRouteId(routeId);
        ArrayList<RouteStation> routeStations = routeStationDao.getRouteStationsBy(routeId);

        routeStations.sort(new Comparator<RouteStation>() {
            public int compare(RouteStation o1, RouteStation o2) {
                return o1.getStationNumber() - o2.getStationNumber();
            }
        });

        ArrayList<Station> stations = new ArrayList<Station>();
        for (RouteStation routeStation: routeStations) {
            stations.add(routeStation.getStation());
        }
        return builder.withStations(stations).build();
    }

    //todo: add unit test!
    public static ArrayList<Route> getAllRoutes() {
        ArrayList<Route> routes = new ArrayList<Route>();
        ArrayList<RouteStation> routeStations = routeStationDao.getAllRouteStations();

        routeStations.sort(new Comparator<RouteStation>() {
            public int compare(RouteStation o1, RouteStation o2) {
                if (o1.getRouteId() == o2.getRouteId()) {
                    return o1.getStationNumber() - o2.getStationNumber();
                } else {
                    return o1.getRouteId() - o2.getRouteId();
                }
            }
        });

        Route.Builder routeBuilder = Route.newBuilder().withRouteId(routeStations.get(0).getRouteId());
        ArrayList<Station> stations = new ArrayList<Station>();
        stations.add(routeStations.get(0).getStation());
        for (int i = 1; i < routeStations.size(); i++) {
            RouteStation currentRouteStation = routeStations.get(i);
            if (currentRouteStation.getRouteId() != routeStations.get(i-1).getRouteId()) {
                routes.add(routeBuilder.withStations(stations).build());
                stations = new ArrayList<Station>();
                routeBuilder.withRouteId(currentRouteStation.getRouteId());
            }
            stations.add(currentRouteStation.getStation());
        }

        routes.add(routeBuilder.withStations(stations).build());
        return routes;
    }

    //todo: add logic;
    public static ArrayList<Route> getRoutes(RouteRequest request) {
        return null;
    }

}
