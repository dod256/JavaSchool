package chuggaChugga.service;

import chuggaChugga.dto.UserDto;

import java.util.List;


public interface UserService {

    List<UserDto> getUsers();
    void addUser(UserDto user);
    UserDto getUserByEmail(String email);
}
