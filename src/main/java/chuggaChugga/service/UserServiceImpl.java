package chuggaChugga.service;

import chuggaChugga.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
*  Implements logic connected to users
*
* */
@Service("userService")
@Transactional
 public class UserServiceImpl implements UserService {

    /*
    @Autowired
    private UserDao userDao;

    public List<User> getUsers() { return userDao.getUsers(); }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByEmail(String email) { return userDao.getUserByEmail(email); }
*/
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria =session.createCriteria(User.class);
        return (User) criteria
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }


    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From User");
        return query.list();
    }

}
