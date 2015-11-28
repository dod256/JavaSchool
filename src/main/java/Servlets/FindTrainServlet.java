package main.java.Servlets;

import main.java.Service;
import main.java.builders.TimetableDtoBuilder;
import main.java.dto.TimetableDto;
import main.java.Entities.Train;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindTrainServlet extends HttpServlet {

        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                String departureStation = req.getParameter("departureStation");
                String arrivalStation = req.getParameter("arrivalStation");;
                DateTime date = DateTime.parse(req.getParameter("date"));
                TimetableDto timetableDto = new TimetableDtoBuilder()
                        .setDepartureStation(departureStation)
                        .setArrivalStation(arrivalStation)
                        .setDate(date)
                        .createTimetableDto();
                ArrayList<Train> trainList = Service.getTrains(timetableDto);
                req.getSession().setAttribute("trainList", trainList);
                res.sendRedirect("/TrainTimetable.jsp");
        }
}
