package chuggaChugga.servlet;

import chuggaChugga.model.Station;
import chuggaChugga.service.StationService;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowStationTimetableServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String stationName = req.getParameter("name");

        Station station = StationService.getStation(stationName);
        DateTime date = DateTime.parse(req.getParameter("date"));
        req.getSession().setAttribute("stationTimetable", StationService.getTimetable(station, date));
        res.sendRedirect("/WEB-INF/pages/StationTimetable.jsp");
    }
}
