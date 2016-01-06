package chuggaChugga.controller;

import chuggaChugga.data.NewRoute;
import chuggaChugga.data.NewRouteImpl;
import chuggaChugga.data.NewRouteStation;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import org.joda.time.LocalTime;
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

    @RequestMapping(value = "/addStationToRoute.form", method = RequestMethod.POST)
    public String addStationToRoute(
            @RequestParam("station") String station,
            @RequestParam("arrivalTime") String arrivalTime,
            @RequestParam("waitingTime") String waitingTime,
            @RequestParam("daysOnWheel") String daysOnWheel,
            HttpSession session) {
        NewRouteStation routeStation = NewRouteStation.newBuilder()
                .withStation(station)
                .withArrivalTime(new LocalTime(arrivalTime))
                .withWaitingTime(new LocalTime(waitingTime))
                .withDaysOnWheel(Integer.parseInt(daysOnWheel))
                .build();
        NewRouteImpl.Builder routeBuilder = (NewRouteImpl.Builder) session.getAttribute("routeBuilder");
        routeBuilder.withNewRouteStation(routeStation);
        return "routeManager";
    }

    @RequestMapping(value = "/createRoute.form", method = RequestMethod.POST)
    public String createRoute(HttpSession session) {
        NewRouteImpl.Builder routeBuilder = (NewRouteImpl.Builder) session.getAttribute("routeBuilder");
        NewRouteImpl route = routeBuilder.build();
        routeService.createRoute(route);
        session.removeAttribute("routeBuilder");
        session.setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Route created"));
        return "showMessage";
    }

    @RequestMapping(value = "/setAddRouteAction.form", method = RequestMethod.POST)
    public String addAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("routeManagerAction", actionType);
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("routeBuilder", NewRouteImpl.newBuilder());
        return "routeManager";
    }

    @RequestMapping(value = "/setShowAllRoutesAction.form", method = RequestMethod.POST)
    public String showAllAction(@RequestParam("actionType") String actionType, HttpSession session) {
        session.setAttribute("routeList", routeService.getAllRoutes());
        session.setAttribute("routeManagerAction", actionType);
        return "routeManager";
    }


}
