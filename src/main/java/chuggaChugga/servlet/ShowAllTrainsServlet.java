package chuggaChugga.servlet;

import chuggaChugga.model.Train;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.service.RouteServiceImpl;
import chuggaChugga.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllTrainsServlet extends HttpServlet {

/*    @Autowired
    TrainService trainService;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ArrayList<Train> trainList = trainService.getAllTrains();
        ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
        for(Train train : trainList) {
            trainDtoList.add(new TrainDto(train, RouteServiceImpl.getRouteById(train.getDepartureStation().getRouteId())));
        }
        req.getSession().setAttribute("trainList", trainDtoList);
        res.sendRedirect("/WEB-INF/pages//trainInfo.jsp");
    }
*/

}
