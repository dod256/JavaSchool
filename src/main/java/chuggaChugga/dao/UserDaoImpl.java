package chuggaChugga.dao;

import chuggaChugga.model.UserDataSet;
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
        return (UserDataSet) sessionFactory
                .openSession()
                .get(UserDataSet.class, id);
    }

    public UserDataSet getUserByEmail(String email) {
        return (UserDataSet) sessionFactory
                .openSession()
                .createCriteria(UserDataSet.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    public List<UserDataSet> getUsers() {
        return sessionFactory.openSession()
                .createCriteria(UserDataSet.class)
                .list();
    }
}
