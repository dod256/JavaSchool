package chuggaChugga.dao;

import chuggaChugga.domain.RouteStationDataSet;
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

    public List<RouteStationDataSet> getRouteStationsById(int routeId) {
        return (List<RouteStationDataSet>) sessionFactory
                .openSession()
                .createCriteria(RouteStationDataSet.class)
                .add(Restrictions.eq("routeId", routeId))
                .list();
    }


    public List<RouteStationDataSet> getAllRouteStations() {
        return (List<RouteStationDataSet>) sessionFactory
                .openSession()
                .createCriteria(RouteStationDataSet.class)
                .list();
    }

    public void addRouteStation(RouteStationDataSet station) {
        Session session = sessionFactory.openSession();
        session.save(station);
        session.close();
    }
}
