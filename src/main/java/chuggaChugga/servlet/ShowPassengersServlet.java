package chuggaChugga.servlet;

import chuggaChugga.dto.UserDto;
import chuggaChugga.service.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowPassengersServlet extends HttpServlet {
/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int trainId = Integer.parseInt(req.getParameter("trainId"));
        ArrayList<UserDto> passengerList = TrainServiceImpl.getPassangers(trainId);
        req.getSession().setAttribute("passengerList", passengerList);
        res.sendRedirect("/WEB-INF/pages/showPassengers.jsp");
    }
*/}
