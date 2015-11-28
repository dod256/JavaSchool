package main.java.Servlets;

import main.java.Service;
import main.java.data.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllRoutesServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Route> routeList = Service.getAllRoutes();
        req.getSession().setAttribute("routeList", routeList);
        res.sendRedirect("addRouteToTrain.jsp");
    }

}
