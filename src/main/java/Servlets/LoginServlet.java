package main.java.Servlets;

import main.java.Entities.User;
import main.java.dto.UserDto;
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
        User user = UserService.getUserByEmail(email);
        if (user != null && user.checkPassword(password)) {
            req.getSession().setAttribute("currentUser", new UserDto(user));
            res.sendRedirect("GetProfileServlet");
        } else {
            res.sendRedirect("loginPage.jsp");
        }
    }
}
