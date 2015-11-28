package main.java.Servlets;

import main.java.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Service.findUser(email) && Service.getUser(email).checkPassword(password)) {
            req.getSession().setAttribute("CurrentUser", Service.getUser(email));
            res.sendRedirect("profile.jsp");
        } else {
            res.sendRedirect("loginPage.jsp");
        }
    }
}
