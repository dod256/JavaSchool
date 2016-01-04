package chuggaChugga.dao;

import chuggaChugga.model.RouteStation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class RouteStationDaoImpl implements RouteStationDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<RouteStation> getRouteStationsById(int routeId) {
        return (List<RouteStation>) sessionFactory
                .openSession()
                .createCriteria(RouteStation.class)
                .add(Restrictions.eq("routeId", routeId))
                .list();
    }


    public List<RouteStation> getAllRouteStations() {
        return (List<RouteStation>) sessionFactory
                .openSession()
                .createCriteria(RouteStation.class)
                .list();
    }

    public void addRouteStation(RouteStation station) {
        Session session = sessionFactory.openSession();
        session.save(station);
        session.close();
    }
}
