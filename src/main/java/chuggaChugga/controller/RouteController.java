package chuggaChugga.controller;

import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RouteController {

    @Autowired
    StationService stationService;

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/setAddRouteAction.form", method = RequestMethod.POST)
    public String addAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("currentManagerAction", actionType);
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("newRouteStationList", null);
        return "routeManager";
    }

    @RequestMapping(value = "/setShowAllRoutesAction.form", method = RequestMethod.POST)
    public String showAllAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("actionObjectList", routeService.getAllRoutes());
        session.setAttribute("currentManagerAction", actionType);
        return "routeManager";
    }


}
