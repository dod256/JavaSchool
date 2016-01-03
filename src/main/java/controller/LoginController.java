package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login.form",method = RequestMethod.GET)
    public String loginGet (@RequestParam("email") String email, @RequestParam("password") String password, Model model){
        return "profile";
    }

    @RequestMapping(value = "/login.form",method = RequestMethod.POST)
    public String loginPost (@RequestParam("email") String email, @RequestParam("password") String password, Model model){
        return "profile";
    }
}
