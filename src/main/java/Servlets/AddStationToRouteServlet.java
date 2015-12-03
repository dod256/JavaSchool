package main.java.Servlets;

import main.java.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddStationToRouteServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("newRouteStationList") == null) {
            req.getSession().setAttribute("newRouteStationList", new ArrayList<String>());
        }
        ArrayList<String> newRouteStationList =
                (ArrayList<String>) req.getSession().
                getAttribute("newRouteStationList");
        newRouteStationList.add("station" +
                (newRouteStationList.size() + 2));
        req.getSession().setAttribute("stationList",
                StationService.getAllStations());
        req.getSession().setAttribute("currentManagerAction", "create");
        res.sendRedirect("routeManager.jsp");
    }
}
