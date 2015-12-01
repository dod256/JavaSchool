package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStationServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //ToDo create Station

        //if seccessed
        req.getSession().setAttribute("currentMessageType", "success");
        req.getSession().setAttribute("currentMessage", "Station added");
        //else
        req.getSession().setAttribute("currentMessageType", "danger");
        req.getSession().setAttribute("currentMessage", "Station already exist");
        res.sendRedirect("showMessage.jsp");
    }

}
