package chuggaChugga.servlet;

import chuggaChugga.data.Route;
import chuggaChugga.data.RouteRequest;
import chuggaChugga.service.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowRoutesServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String departureStation = req.getParameter("departureStation");
        String arrivalStation = req.getParameter("arrivalStation");;
        RouteRequest request = RouteRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .build();
        ArrayList<Route> routeList = RouteServiceImpl.getRoutes(request);

        req.getSession().setAttribute("routeList", routeList);

        res.sendRedirect("/WEB-INF/pages/addRouteToTrain.jsp");
    }
*/
}