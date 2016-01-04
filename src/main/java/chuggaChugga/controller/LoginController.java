package chuggaChugga.controller;

import chuggaChugga.dto.UserDto;
import chuggaChugga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login.form",method = RequestMethod.POST)
    public String loginPost (@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        UserDto user = userService.getUserByEmail(email);
        if (user != null && user.checkPassword(password)) {
            session.setAttribute("currentUser", user);
            return "profile";
        } else {
            return "login";
        }
    }
}
