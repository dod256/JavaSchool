package chuggaChugga.servlet;

import chuggaChugga.service.RouteServiceImpl;
import chuggaChugga.service.StationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RouteManagerSetActionServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("showAll")) {
            req.getSession().setAttribute("actionObjectList", RouteServiceImpl.getAllRoutes());
        }
        req.getSession().setAttribute("stationList", StationServiceImpl.getAllStations());
        req.getSession().setAttribute("currentManagerAction", actionType);
        req.getSession().setAttribute("newRouteStationList", null);
        res.sendRedirect("/WEB-INF/pages/routeManager.jsp");
    }*/
}
