package chuggaChugga.service;

import chuggaChugga.dao.RouteStationDao;
import chuggaChugga.model.RouteStationDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Response for adding new lines in DB table RouteStationDataSet
 */

@Service
@Transactional
public class RouteStationServiceImpl implements RouteStationService {

    @Autowired
    private RouteStationDao routeStationDao;

    public void addRouteStation(RouteStationDataSet station) {
        routeStationDao.addRouteStation(station);
    }

}
