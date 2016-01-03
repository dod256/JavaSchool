package chuggaChugga.service;

import chuggaChugga.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public interface UserService {

    public List<User> getUsers();

    public void addUser(User user);

    public User getUserByEmail(String email);
}
