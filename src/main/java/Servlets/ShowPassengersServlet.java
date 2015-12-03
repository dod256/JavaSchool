package main.java.Servlets;

import main.java.dto.UserDto;
import main.java.services.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowPassengersServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        ArrayList<UserDto> passengerList = TrainService.getPassangers(trainId);
        req.getSession().setAttribute("passengerList", passengerList);
        res.sendRedirect("showPassengers.jsp");
    }
}
