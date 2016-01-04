package chuggaChugga.servlet;

import javax.servlet.http.HttpServlet;

public class ShowStationTimetableServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String stationName = req.getParameter("name");

        StationDataSet station = StationServiceImpl.getStation(stationName);
        DateTime date = DateTime.parse(req.getParameter("date"));
        req.getSession().setAttribute("stationTimetable", StationServiceImpl.getTimetable(station, date));
        res.sendRedirect("/WEB-INF/pages/StationTimetable.jsp");
    }*/
}
