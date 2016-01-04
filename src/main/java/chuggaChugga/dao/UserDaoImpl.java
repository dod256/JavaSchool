package chuggaChugga.dao;

import chuggaChugga.model.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addUser(UserDataSet user) {
        Session session = sessionFactory.openSession();
        session.persist(user);
        session.close();
    }

    public UserDataSet getUser(int id) {
        Session session = sessionFactory.openSession();
        return (UserDataSet) session.get(UserDataSet.class, id);
    }

    public UserDataSet getUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) criteria
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    public List<UserDataSet> getUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From UserDataSet");
        return query.list();
    }
}
