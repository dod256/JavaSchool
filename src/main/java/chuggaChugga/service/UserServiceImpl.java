package chuggaChugga.service;

import chuggaChugga.dao.UserDao;
import chuggaChugga.dto.UserDto;
import chuggaChugga.domain.UserDataSet;
import org.apache.log4j.Logger;
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

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public List<UserDto> getUsers() {
        List<UserDataSet> userList = userDao.getUsers();
        List<UserDto> userDtoList = new ArrayList<>();
        for(UserDataSet user : userList) {
            userDtoList.add(UserDto.newBuilder(user).build());
        }
        return userDtoList;
    }

    public void addUser(UserDto user) {
        userDao.addUser(UserDataSet.newBuilder(user).build());
        logger.info("User " + user.toString() + " created");
    }

    @Override
    public void updateUser(UserDto user) {
        userDao.updateUser(UserDataSet.newBuilder(user).build());
    }

    public UserDto getUserByEmail(String email) {
        return UserDto.newBuilder(userDao.getUserByEmail(email)).build();
    }

}
