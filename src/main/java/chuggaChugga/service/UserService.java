package chuggaChugga.service;

import chuggaChugga.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional
public interface UserService {

    List<User> getUsers();
    void addUser(User user);
    User getUserByEmail(String email);
}
