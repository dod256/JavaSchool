package chuggaChugga.service;

import chuggaChugga.dao.RouteStationDao;
import chuggaChugga.model.RouteStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Response for adding new lines in DB table RouteStation
 */

@Service
public class RouteStationServiceImpl implements RouteStationService {

    @Autowired
    private RouteStationDao routeStationDao;

    public void addRouteStation(RouteStation station) {
        routeStationDao.addRouteStation(station);
    }

}
