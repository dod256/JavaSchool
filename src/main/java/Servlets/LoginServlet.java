package main.java.Servlets;

import main.java.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (UserService.getUserByEmail(email) != null && UserService.getUserByEmail(email).checkPassword(password)) {
            req.getSession().setAttribute("currentUser", UserService.getUserByEmail(email));
            res.sendRedirect("GetProfileServlet");
        } else {
            res.sendRedirect("loginPage.jsp");
        }
    }
}
