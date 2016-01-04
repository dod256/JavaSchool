package chuggaChugga.dao;

import chuggaChugga.model.RouteLengthDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class RouteLengthDaoImpl implements RouteLengthDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addRouteLength(RouteLengthDataSet routeLength) {
        Session session = sessionFactory.openSession();
        session.save(routeLength);
        session.close();
    }

    public List<RouteLengthDataSet> getAllRouteLength() {
        return (List<RouteLengthDataSet>) sessionFactory
                .openSession()
                .createCriteria(RouteLengthDataSet.class)
                .list();
    }
}
