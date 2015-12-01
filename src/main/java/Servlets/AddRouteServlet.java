package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRouteServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //ToDo create Route
        req.getSession().setAttribute("currentMessageType", "success");
        req.getSession().setAttribute("currentMessage", "Route added");
        res.sendRedirect("showMessage.jsp");
    }

}
