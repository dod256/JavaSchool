package chuggaChugga.controller;

import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.service.StationService;
import chuggaChugga.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/trainManager.html", method = RequestMethod.GET)
    public String trainManager(HttpSession session){
        session.removeAttribute("trainManagerAction");
        session.removeAttribute("trainList");
        return "trainManager";
    }

    @RequestMapping(value = "/stationManager.html", method = RequestMethod.GET)
    public String stationManager(HttpSession session){
        session.removeAttribute("stationManagerAction");
        session.removeAttribute("stationList");
        return "stationManager";
    }

    @RequestMapping(value = "/pathManager.html", method = RequestMethod.GET)
    public String pathManager(HttpSession session){
        session.removeAttribute("pathType");
        return "pathManager";
    }

    @RequestMapping(value = "/routeManager.html", method = RequestMethod.GET)
    public String routeManager(HttpSession session){
        session.removeAttribute("routeManagerAction");
        session.removeAttribute("routeList");
        return "routeManager";
    }

    @RequestMapping(value = "/stationTimetable.html", method = RequestMethod.GET)
    public String stationTimetable(HttpSession session){
        session.removeAttribute("stationTimetable");
        session.setAttribute("stationList", stationService.getAllStations());
        return "stationTimetable";
    }

    @RequestMapping(value = "/findTrain.html", method = RequestMethod.GET)
    public String findTrain(HttpSession session){
        session.removeAttribute("trainTimetable");
        session.setAttribute("stationList", stationService.getAllStations());
        return "trainTimetable";
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
