package chuggaChugga.dao;

import chuggaChugga.model.TrainDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void addTrain(TrainDataSet train) {
        Session session = sessionFactory.openSession();
        session.save(train);
        session.close();
    }

    public int getTrainTableSize() {
        return sessionFactory
                    .openSession()
                    .createCriteria(TrainDataSet.class)
                    .list()
                    .size();
    }

    public List<TrainDataSet> getAllTrains() {
        return (List<TrainDataSet>) sessionFactory
                    .openSession()
                    .createCriteria(TrainDataSet.class)
                    .list();
    }

    public TrainDataSet getTrain(int id) {
        return (TrainDataSet) sessionFactory.openSession()
                    .createCriteria(TrainDataSet.class)
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();
    }
}
