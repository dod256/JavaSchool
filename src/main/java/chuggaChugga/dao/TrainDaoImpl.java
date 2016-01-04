package chuggaChugga.dao;

import chuggaChugga.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addTrain(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.save(train);
        session.close();
    }


    public int getTrainTableSize() {
        return sessionFactory
                    .getCurrentSession()
                    .createCriteria("Train.class")
                    .list()
                    .size();
    }

    public List<Train> getAllTrains() {
        return (List<Train>) sessionFactory
                    .getCurrentSession()
                    .createCriteria("Train.class")
                    .list();
    }

    public Train getTrain(int id) {
        return (Train) sessionFactory.getCurrentSession()
                    .createCriteria("Train.class")
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();
    }
}
