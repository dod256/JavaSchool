package main.java.Servlets;

import main.java.services.RouteService;
import main.java.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RouteManagerSetActionServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("showAll")) {
            req.getSession().setAttribute("actionObjectList", RouteService.getAllRoutes());
        }
        req.getSession().setAttribute("stationList", StationService.getAllStations());
        req.getSession().setAttribute("currentManagerAction", actionType);
        req.getSession().setAttribute("newRouteStationList", null);
        res.sendRedirect("routeManager.jsp");
    }
}
