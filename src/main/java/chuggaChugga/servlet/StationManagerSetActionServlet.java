package chuggaChugga.servlet;

import chuggaChugga.service.StationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StationManagerSetActionServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        req.getSession().setAttribute("actionObjectList", StationServiceImpl.getAllStations());
        req.getSession().setAttribute("currentManagerAction", actionType);
        res.sendRedirect("/WEB-INF/pages/stationManager.jsp");
    }*/
}
