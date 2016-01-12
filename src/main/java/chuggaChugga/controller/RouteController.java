package chuggaChugga.controller;

import chuggaChugga.data.NewRouteImpl;
import chuggaChugga.data.NewRouteStation;
import chuggaChugga.data.Route;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.helper.ResultMessage;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RouteController extends MyController {

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
        if (session.getAttribute("routeBuilder") == null) {
            session.setAttribute("routeBuilder", NewRouteImpl.newBuilder());
        }
        NewRouteImpl.Builder routeBuilder = (NewRouteImpl.Builder) session.getAttribute("routeBuilder");
        routeBuilder.withNewRouteStation(routeStation);
        session.removeAttribute("routeBuilder");
        return "route/createRoute";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllRoutes.html", method = RequestMethod.GET)
    public String showAllRoutes(HttpSession session) {
        saveUserInSession(session);
        ArrayList<Route> routeFullList = routeService.getAllRoutes();
        int length = routeFullList.size();
        session.setAttribute("routeFullList", routeFullList);
        session.setAttribute("routePager", 0);
        session.setAttribute("routeMaxPager", (
                length / maxNumberOfElementsOnPage) +
                (length % maxNumberOfElementsOnPage == 0 ? 0 : 1));
        int n = Math.min(maxNumberOfElementsOnPage, routeFullList.size());
        ArrayList<Route> routeList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            routeList.add(routeFullList.get(i));
        }
        session.setAttribute("routeList", routeList);
        return "route/showAllRoutes";
    }

    @RequestMapping(value = "/routePagerInc.html", method = RequestMethod.GET)
    public String pagerInc(HttpSession session) {
        int pager = (int) session.getAttribute("routePager");
        int maxPager = (int) session.getAttribute("routeMaxPager");
        if (pager + 1 < maxPager) {
            pager++;
        }
        session.setAttribute("routePager", pager);

        ArrayList<Route> routeFullList = (ArrayList<Route>) session.getAttribute("routeFullList");
        int n = Math.min((pager + 1) * maxNumberOfElementsOnPage, routeFullList.size());
        ArrayList<Route> routeList = new ArrayList<>();
        for(int i = pager * maxNumberOfElementsOnPage; i < n; i++) {
            routeList.add(routeFullList.get(i));
        }
        session.setAttribute("routeList", routeList);

        return "route/showAllRoutes";
    }

    @RequestMapping(value = "/routePagerDec.html", method = RequestMethod.GET)
    public String pagerDec(HttpSession session) {
        int pager = (int) session.getAttribute("routePager");
        if (pager > 0) {
            pager--;
        }
        session.setAttribute("routePager", pager);

        ArrayList<Route> routeFullList = (ArrayList<Route>) session.getAttribute("routeFullList");
        int n = Math.min((pager + 1) * maxNumberOfElementsOnPage, routeFullList.size());
        ArrayList<Route> routeList = new ArrayList<>();
        for(int i = pager * maxNumberOfElementsOnPage; i < n; i++) {
            routeList.add(routeFullList.get(i));
        }
        session.setAttribute("routeList", routeList);

        return "route/showAllRoutes";
    }

    @RequestMapping(value = "/createRoute.form", method = RequestMethod.POST)
    public String createRoute(HttpSession session) {
        NewRouteImpl.Builder routeBuilder = (NewRouteImpl.Builder) session.getAttribute("routeBuilder");
        NewRouteImpl route = routeBuilder.build();
        routeService.createRoute(route);
        session.removeAttribute("routeBuilder");
        session.setAttribute("operationResultMessage",
                new ResultMessage("success", "Route created"));
        return "showMessage";
    }

}
