package chuggaChugga.service;

import chuggaChugga.dao.RouteLengthDao;
import chuggaChugga.model.RouteLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RouteLengthServiceImpl implements RouteLengthService {
    @Autowired
    private RouteLengthDao routeLengthDao;

    public void addRouteLength(int length) {
        routeLengthDao.addRouteLength(new RouteLength(length));
    }

    public int getFreeRouteId() {
        return routeLengthDao.getAllRouteLength().size() + 1;
    }

}
