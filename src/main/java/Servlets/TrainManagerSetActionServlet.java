package main.java.Servlets;

import main.java.services.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TrainManagerSetActionServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("delete")) {
            req.getSession().setAttribute("actionObjectList", TrainService.getAllTrains());
        }
        req.getSession().setAttribute("currentManagerAction", actionType);
        res.sendRedirect("trainManager.jsp");
    }
}
