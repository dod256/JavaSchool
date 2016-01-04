package chuggaChugga.dao;

import chuggaChugga.model.User;
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

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.persist(user);
        session.close();
    }

    public User getUser(int id) {
        Session session = sessionFactory.openSession();
        return (User) session.get(User.class, id);
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }


    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From User");
        return query.list();
    }
}
