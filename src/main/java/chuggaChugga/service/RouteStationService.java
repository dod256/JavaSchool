package chuggaChugga.service;

import chuggaChugga.model.RouteStation;
import chuggaChugga.dao.RouteStationDao;


/**
 *  Response for adding new lines in DB table RouteStation
 */
public class RouteStationService extends Service {

    private static RouteStationDao routeStationDao = new RouteStationDao(em);

    public static void addRouteStation(RouteStation station) {
        routeStationDao.addRouteStation(station);
    }

}
