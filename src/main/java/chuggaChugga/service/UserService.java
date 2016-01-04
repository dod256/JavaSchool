package chuggaChugga.service;

import chuggaChugga.dto.UserDto;
import chuggaChugga.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional
public interface UserService {

    List<UserDto> getUsers();
    void addUser(UserDto user);
    UserDto getUserByEmail(String email);
}
