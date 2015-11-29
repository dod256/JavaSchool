package main.java.Servlets;

import main.java.data.Route;
import main.java.data.RouteRequest;
import main.java.services.RouteService;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowRoutesServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String departureStation = req.getParameter("departureStation");
        String arrivalStation = req.getParameter("arrivalStation");;
        DateTime firstTime = DateTime.parse(req.getParameter("firstTime"));
        DateTime secondTime = DateTime.parse(req.getParameter("secondTime"));
        RouteRequest request = RouteRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .withFirstTime(firstTime)
                .withSecondTime(secondTime)
                .build();
        ArrayList<Route> routeList = RouteService.getRoutes(request);
        req.getSession().setAttribute("routeList", routeList);

        res.sendRedirect("addRouteToTrain.jsp");
    }

}
