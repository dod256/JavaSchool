package chuggaChugga.dao;

import chuggaChugga.model.Station;
import chuggaChugga.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addStation(Station station) {
        Session session = sessionFactory.openSession();
        session.save(station);
        session.close();
    }

    public Station getStation(String name) {
        return (Station) sessionFactory.openSession()
              .createCriteria(Station.class)
              .add(Restrictions.eq("name", name))
              .uniqueResult();
    }

    public List<Station> getAllStations() {
        return (List<Station>) sessionFactory.openSession()
                      .createCriteria(Station.class)
                      .list();
    }
}
