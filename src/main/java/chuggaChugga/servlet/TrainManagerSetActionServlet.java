package chuggaChugga.servlet;

import chuggaChugga.model.Train;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TrainManagerSetActionServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("delete")) {
            ArrayList<Train> trainList = TrainService.getAllTrains();
            ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
            for(Train train : trainList) {
                trainDtoList.add(new TrainDto(train, RouteService.getRouteById(train.getDepartureStation().getRouteId())));
            }

            req.getSession().setAttribute("actionObjectList", trainDtoList);
        }

        if (actionType.equals("showAll")) {
            ArrayList<Train> trainList = TrainService.getAllTrains();
            ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
            for(Train train : trainList) {
                trainDtoList.add(new TrainDto(train, RouteService.getRouteById(train.getDepartureStation().getRouteId())));
            }

            req.getSession().setAttribute("actionObjectList", trainDtoList);
        }

        req.getSession().setAttribute("currentManagerAction", actionType);
        res.sendRedirect("/WEB-INF/pages/trainManager.jsp");
    }
}
