package main.java.services;


import main.java.Entities.RouteLength;
import main.java.dao.RouteLengthDao;

public class RouteLengthService extends Service {
    private static RouteLengthDao routeLengthDao = new RouteLengthDao(em);

    public static void addRouteLength(int length) {
        routeLengthDao.addRouteLength(new RouteLength(length));
    }

    public static int getFreeRouteId() {
        return routeLengthDao.getAllRouteLength().size() + 1;
    }

}