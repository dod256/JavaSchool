package chuggaChugga.service;

import chuggaChugga.dao.UserDao;
import chuggaChugga.dto.UserDto;
import chuggaChugga.model.UserDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
*  Implements logic connected to users
*
* */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<UserDto> getUsers() {
        List<UserDataSet> userList = userDao.getUsers();
        List<UserDto> userDtoList = new ArrayList<>();
        for(UserDataSet user : userList) {
            userDtoList.add(new UserDto(user));
        }
        return userDtoList;
    }

    public void addUser(UserDto user) {
        userDao.addUser(new UserDataSet(user));
    }

    public UserDto getUserByEmail(String email) {
        return new UserDto(userDao.getUserByEmail(email));
    }

}
