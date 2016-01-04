package chuggaChugga.controller;

import chuggaChugga.dto.UserDto;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.model.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import chuggaChugga.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signUp.form", method = RequestMethod.POST)
    public String loginPost (@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("secondPassword") String secondPassword,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("birthdate") String birthdate,
                             HttpSession session){

        OperationResultMessage message = ValidatorImpl.checkEmail(email);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        message = ValidatorImpl.checkPasswords(password, secondPassword);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        message = ValidatorImpl.checkName(firstName);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        message = ValidatorImpl.checkName(lastName);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        message = ValidatorImpl.checkDate(birthdate);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        
        DateTime dt = DateTime.parse(birthdate);
        UserDto userDto = UserDto.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(dt)
                .withUserTypeId(2)
                .build();

        userService.addUser(userDto);
        return "index";
    }

}
