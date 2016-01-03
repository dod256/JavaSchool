package servlet;

import model.Train;
import dto.TrainDto;
import service.RouteService;
import service.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllTrainsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ArrayList<Train> trainList = TrainService.getAllTrains();
        ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
        for(Train train : trainList) {
            trainDtoList.add(new TrainDto(train, RouteService.getRouteById(train.getDepartureStation().getRouteId())));
        }
        req.getSession().setAttribute("trainList", trainDtoList);
        res.sendRedirect("/WEB-INF/pages//trainInfo.jsp");
    }


}
