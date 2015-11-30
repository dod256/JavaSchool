package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetProfileServlet extends HttpServlet {


    private void preparation(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            res.sendRedirect("loginPage.jsp");
            return;
        }
        //ToDo complete after adding a TicketService
        //req.getSession().setAttribute("ticketList", );
        res.sendRedirect("profile.jsp");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        preparation(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        preparation(req, res);
    }


}
