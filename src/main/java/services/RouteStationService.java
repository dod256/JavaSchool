package main.java.services;


import main.java.Entities.RouteStation;
import main.java.dao.RouteStationDao;

public class RouteStationService extends Service {

    private static RouteStationDao routeStationDao = new RouteStationDao(em);

    public static void addRouteStation(RouteStation station) {
        routeStationDao.addRouteStation(station);
    }

}
