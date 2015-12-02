package main.java.Servlets;

import main.java.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrepareFindTrainServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getSession().setAttribute("stationList", StationService.getAllStations());
        res.sendRedirect("TrainTimetable.jsp");
    }

}
