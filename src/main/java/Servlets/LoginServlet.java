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
            res.sendRedirect("profile.jsp");
=======
        if (UserService.getUser(email) != null && UserService.getUser(email).checkPassword(password)) {
            req.getSession().setAttribute("currentUser", UserService.getUser(email));
            res.sendRedirect("GetProfileServlet");
>>>>>>> Stashed changes
        } else {
            res.sendRedirect("loginPage.jsp");
        }
    }
}
