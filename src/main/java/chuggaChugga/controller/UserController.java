package chuggaChugga.controller;

import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.helper.ResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.service.TicketService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController extends MyController {

    @Autowired
    TicketService ticketService;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/makeDeposit.form",method = RequestMethod.POST)
    public String makeDeposit(
                @RequestParam("deposit") String deposit,
                HttpSession session) {
            UserDto user = (UserDto) session.getAttribute("currentUser");
            ResultMessage check = ValidatorImpl.checkNumber(deposit);
        
            user.makeDeposit(Integer.parseInt(deposit));
            userService.updateUser(user);
            //ToDo get by id
            session.setAttribute("currentUser", userService.getUserByEmail(user.getEmail()));
            ArrayList<TicketDto> ticketList = ticketService.getTicketsByUser((UserDto) session.getAttribute("currentUser"));
            session.setAttribute("ticketList", ticketList);
            return "user/profile";
    }

    @RequestMapping(value = "/loginSuccess",method = RequestMethod.GET)
    public String loginSuccess (HttpSession session){
        saveUserInSession(session);
        ArrayList<TicketDto> ticketList = ticketService.getTicketsByUser((UserDto) session.getAttribute("currentUser"));
        session.setAttribute("ticketList", ticketList);
        return "user/profile";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.removeAttribute("currentUser");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login.html?logout";
    }

    @RequestMapping(value = "/signUp.form", method = RequestMethod.POST)
    public String signUp (@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("secondPassword") String secondPassword,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("birthdate") String birthdate,
                             HttpSession session){
        if ("danger".equals(ValidatorImpl.checkName(firstName).getStatus())) {
            return "redirect:/signUp.html?invalidName";
        }
        if ("danger".equals(ValidatorImpl.checkName(lastName).getStatus())) {
            return "redirect:/signUp.html?invalidName";
        }
        if ("danger".equals(ValidatorImpl.checkEmail(email).getStatus())) {
            return "redirect:/signUp.html?invalidEmail";
        }
        if ("danger".equals(ValidatorImpl.generalCheck(password).getStatus())) {
            return "redirect:/signUp.html?invalidPass1";
        }
        if ("danger".equals(ValidatorImpl.generalCheck(secondPassword).getStatus())) {
            return "redirect:/signUp.html?invalidPass2";
        }
        if ("danger".equals(ValidatorImpl.checkPasswords(password, secondPassword).getStatus())) {
            return "redirect:/signUp.html?invalidPass";
        }
        if ("danger".equals(ValidatorImpl.checkDate(birthdate).getStatus())) {
            return "redirect:/signUp.html?invalidDate";
        }

        DateTime dt = DateTime.parse(birthdate);
        UserDto userDto = UserDto.newBuilder()
                .withEmail(email)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthdate(dt)
                .build();

        userService.addUser(userDto);
        return "index";
    }

}
