package chuggaChugga.dao;

import chuggaChugga.model.RouteLength;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class RouteLengthDaoImpl implements RouteLengthDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addRouteLength(RouteLength routeLength) {
        Session session = sessionFactory.openSession();
        session.save(routeLength);
        session.close();
    }

    public List<RouteLength> getAllRouteLength() {
        return (List<RouteLength>) sessionFactory
                .openSession()
                .createCriteria(RouteLength.class)
                .list();
    }
}
