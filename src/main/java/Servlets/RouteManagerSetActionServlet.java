package main.java.Servlets;

import main.java.services.RouteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RouteManagerSetActionServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("delete")) {
            req.getSession().setAttribute("actionObjectList", RouteService.getAllRoutes());
        }
        req.getSession().setAttribute("currentManagerAction", actionType);
        res.sendRedirect("routeManager.jsp");
    }
}
