package chuggaChugga.controller;

import chuggaChugga.dto.UserDto;
import chuggaChugga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    protected String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    protected void saveUserInSession(HttpSession session) {
        String username = getPrincipal();
        UserDto user = userService.getUserByEmail(username);
        session.setAttribute("currentUser", user);
    }
}
