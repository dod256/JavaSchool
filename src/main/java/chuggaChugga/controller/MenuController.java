package chuggaChugga.controller;

import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import chuggaChugga.service.TicketServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MenuController {
    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/signUp.html", method = RequestMethod.GET)
    public String signUp(Model model){
        return "signUp";
    }

    @RequestMapping(value = "/profile.html", method = RequestMethod.GET)
    public String profile(HttpSession session){
        if (session.getAttribute("currentUser") == null) {
            return "login";
        }
        ArrayList<TicketDto> ticketList = ticketService.getTicketsByUser((UserDto) session.getAttribute("currentUser"));
        session.setAttribute("ticketList", ticketList);
        return "profile";
    }

}
