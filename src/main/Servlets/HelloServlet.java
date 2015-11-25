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

public class HelloServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = null;
        res.setContentType("text/html");
        out = res.getWriter();

        out.println("<html>");
        out.println("<head><title>Sample</title></head>");
        out.println("<body>");
        out.print("Hello, ");
        String name = req.getParameter("name");
        out.println(name);
        out.println("</body>");
        out.println("</html>");
        out.close();
        //getServletContext().getRequestDispatcher("/hello.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ArrayList<User> users = Service.getUsers();
        String email = req.getParameter("login");
        User currentUser = null;
        boolean flag = false;
        for(User user : users) {
            if (email.equals(user.getEmail())) {
                flag = true;
                currentUser = user;
                break;
            }
        }
        if (!flag) {
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("login.html");
            rd.forward(req, res);
            return;
        }
        PrintWriter out = null;
        res.setContentType("text/html");
        out = res.getWriter();

        out.println("<html>");
        out.println("<head><title>Sample</title></head>");
        out.println("<body>");
        out.print("Hello, ");
        out.println(currentUser.getFirstName());
        out.println("</body>");
        out.println("</html>");
        out.close();
        //getServletContext().getRequestDispatcher("/hello.jsp").forward(req, res);
    }
}
