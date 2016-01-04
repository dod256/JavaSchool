package chuggaChugga.controller;

import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.service.StationService;
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

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/home.html", method = RequestMethod.GET)
    public String home(Model model){
        return "index";
    }

    @RequestMapping(value = "/trainManager.html", method = RequestMethod.GET)
    public String trainManager(Model model){
        return "trainManager";
    }

    @RequestMapping(value = "/stationManager.html", method = RequestMethod.GET)
    public String stationManager(Model model){
        return "stationManager";
    }

    @RequestMapping(value = "/routeManager.html", method = RequestMethod.GET)
    public String routeManager(Model model){
        return "routeManager";
    }

    @RequestMapping(value = "/stationTimetable.html", method = RequestMethod.GET)
    public String stationTimetable(HttpSession session){
        session.setAttribute("stationList", stationService.getAllStations());
        return "stationTimetable";
    }

    @RequestMapping(value = "/findTrain.html", method = RequestMethod.GET)
    public String findTrain(HttpSession session){
        session.setAttribute("stationList", stationService.getAllStations());
        return "stationTimetable";
    }

    @RequestMapping(value = "/signUp.html", method = RequestMethod.GET)
    public String signUp(Model model){
        return "signUp";
    }

    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute("currentUser", null);
        return "index";
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
