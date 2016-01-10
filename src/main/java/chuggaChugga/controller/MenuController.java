package chuggaChugga.controller;

import chuggaChugga.dto.TicketDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import chuggaChugga.service.TicketService;
import chuggaChugga.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MenuController extends MyController {

    @Autowired
    TicketService ticketService;

    @Autowired
    StationService stationService;

    @Autowired
    TrainService trainService;

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(Model model){
        return "user/login";
    }

    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute("currentUser", null);
        return "index";
    }

    @RequestMapping(value = "/home.html", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/createStation.html", method = RequestMethod.GET)
    public String createStation(HttpSession session) {
        saveUserInSession(session);
        return "station/createStation";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllStations.html", method = RequestMethod.GET)
    public String showAllStations(HttpSession session) {
        saveUserInSession(session);
        session.setAttribute("stationList", stationService.getAllStationsOrderdByName());
        return "station/showAllStations";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/createTrain.html", method = RequestMethod.GET)
    public String createTrain(HttpSession session) {
        saveUserInSession(session);
        return "train/createTrain";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllTrains.html", method = RequestMethod.GET)
    public String showAllTrains(HttpSession session) {
        saveUserInSession(session);
        session.setAttribute("trainList", trainService.getAllTrains());
        return "train/showAllTrains";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/createRoute.html", method = RequestMethod.GET)
    public String createRoute(HttpSession session) {
        saveUserInSession(session);
        return "route/createRoute";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllRoutes.html", method = RequestMethod.GET)
    public String showAllRoutes(HttpSession session) {
        saveUserInSession(session);
        session.setAttribute("routeList", routeService.getAllRoutes());
        return "route/showAllRoutes";
    }

    @RequestMapping(value = "/pathManager.html", method = RequestMethod.GET)
    public String pathManager(HttpSession session){
        session.removeAttribute("pathType");
        return "pathManager";
    }

    @RequestMapping(value = "/stationTimetable.html", method = RequestMethod.GET)
    public String stationTimetable(HttpSession session){
        session.removeAttribute("stationTimetable");
        session.setAttribute("stationList", stationService.getAllStations());
        return "station/stationTimetable";
    }

    @RequestMapping(value = "/findTrain.html", method = RequestMethod.GET)
    public String findTrain(HttpSession session){
        session.removeAttribute("trainTimetable");
        session.setAttribute("stationList", stationService.getAllStations());
        return "train/trainTimetable";
    }

    @RequestMapping(value = "/signUp.html", method = RequestMethod.GET)
    public String signUp(Model model){
        return "user/signUp";
    }

    @RequestMapping(value = "/profile.html", method = RequestMethod.GET)
    public String profile(HttpSession session){
        if (session.getAttribute("currentUser") == null) {
            return "user/login";
        }
        ArrayList<TicketDto> ticketList = ticketService.getTicketsByUser((UserDto) session.getAttribute("currentUser"));
        session.setAttribute("ticketList", ticketList);
        return "user/profile";
    }

}
