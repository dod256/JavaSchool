package chuggaChugga.controller;

import chuggaChugga.dto.UserDto;
import chuggaChugga.model.User;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import chuggaChugga.service.UserService;

@Controller
public class SignUpController {

    //@Autowired
    //UserService userService;

    @RequestMapping(value = "/signUp.form", method = RequestMethod.POST)
    public String loginPost (@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("birthdate") String birthdate,
                             Model model){

        DateTime dt = DateTime.parse(birthdate);
        UserDto userDto = UserDto.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(dt)
                .withUserTypeId(2)
                .build();
        User user = new User(userDto);
        //userService.addUser(user);
        return "index";
    }

}
