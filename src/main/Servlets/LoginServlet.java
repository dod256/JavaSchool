package main.Servlets;

import main.Service;
import main.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<User> users = Service.getUsers();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean flag = false;
        for(User user : users) {
            if (email.equals(user.getEmail()) && user.checkPassword(password)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            res.sendRedirect("login.html");
            return;
        }
        res.sendRedirect("profile.jsp");
    }
}
