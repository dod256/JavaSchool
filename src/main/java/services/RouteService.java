package main.java.services;

import main.java.Entities.RouteStation;
import main.java.Entities.Station;
import main.java.Service;
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

    //todo: second priority
    public static ArrayList<Route> getAllRoutes() {
        return null;
    }

    //todo: add logic;
    public static ArrayList<Route> getRoutes(RouteRequest request) {
        return null;
    }

}
