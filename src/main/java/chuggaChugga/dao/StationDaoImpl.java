package chuggaChugga.dao;

import chuggaChugga.domain.StationDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void addStation(StationDataSet station) {
        Session session = sessionFactory.openSession();
        session.save(station);
        session.close();
    }

    public StationDataSet getStationByName(String name) {
        return (StationDataSet) sessionFactory.openSession()
              .createCriteria(StationDataSet.class)
              .add(Restrictions.eq("name", name))
              .uniqueResult();
    }

    public StationDataSet getStation(int id) {
        return (StationDataSet) sessionFactory.openSession()
                .get(StationDataSet.class, id);
    }

    public List<StationDataSet> getAllStations() {
        return (List<StationDataSet>) sessionFactory.openSession()
                      .createCriteria(StationDataSet.class)
                      .list();
    }
}
