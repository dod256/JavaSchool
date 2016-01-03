package servlet;

import dto.TicketDto;
import dto.UserDto;
import service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetProfileServlet extends HttpServlet {


    private void preparation(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            res.sendRedirect("/WEB-INF/pages/login.jsp");
            return;
        }
        ArrayList<TicketDto> ticketList = TicketService.getTicketsByUser((UserDto) req.getSession().getAttribute("currentUser"));
        req.getSession().setAttribute("ticketList", ticketList);
        res.sendRedirect("/WEB-INF/pages/profile.jsp");
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
