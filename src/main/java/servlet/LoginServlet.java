package servlet;

import model.User;
import dto.UserDto;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        /*
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = UserServiceImpl.getUserByEmail(email);
        if (user != null && user.checkPassword(password)) {
            req.getSession().setAttribute("currentUser", new UserDto(user));
            res.sendRedirect("/WEB-INF/pages/GetProfileServlet");
        } else {
            res.sendRedirect("/WEB-INF/pages/login.jsp");
        }
        */
    }
}
