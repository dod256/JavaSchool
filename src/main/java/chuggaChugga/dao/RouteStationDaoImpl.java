package chuggaChugga.dao;

import chuggaChugga.model.RouteStation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class RouteStationDaoImpl implements RouteStationDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<RouteStation> getRouteStationsById(int routeId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(RouteStation.class);
        return (List<RouteStation>) criteria
                .add(Restrictions.eq("routeId", routeId))
                .list();
    }


    public List<RouteStation> getAllRouteStations() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(RouteStation.class);
        return (List<RouteStation>)criteria.list();
    }

    public void addRouteStation(RouteStation station) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(station);
        transaction.commit();
        session.close();
    }
}
