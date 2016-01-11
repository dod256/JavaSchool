package chuggaChugga.dao;

import chuggaChugga.domain.RouteLengthDataSet;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.math.BigInteger;

@Repository
public class RouteLengthDaoImpl implements RouteLengthDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addRouteLength(RouteLengthDataSet routeLength) {
        Session session = sessionFactory.openSession();
        session.save(routeLength);
        session.close();
    }

    @Override
    public int getFreeRouteId() {
        Session session = sessionFactory.openSession();
        String s = "SELECT COUNT(*) FROM routelength;";
        SQLQuery query = session.createSQLQuery(s);
        return ((BigInteger)query.uniqueResult()).intValue();
    }
}
