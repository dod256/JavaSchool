package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByEmail(String email) {
        //ToDo get(0) is ok? NullPointer? ProTip:createQuery("select u from User as u where u.email =:email").setParameter("email", email).getResultList();
        return (User) entityManager.createQuery("from User where email = '" + email + "'").getResultList().get(0);
    }


    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT a FROM User a", User.class);
        return query.getResultList();
    }
}
