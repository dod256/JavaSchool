package chuggaChugga.servlet;

import javax.servlet.http.HttpServlet;

public class ShowAllTrainsServlet extends HttpServlet {

/*    @Autowired
    TrainService trainService;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ArrayList<TrainDataSet> trainList = trainService.getAllTrains();
        ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
        for(TrainDataSet train : trainList) {
            trainDtoList.add(new TrainDto(train, RouteServiceImpl.getRouteById(train.getDepartureStation().getRouteId())));
        }
        req.getSession().setAttribute("trainList", trainDtoList);
        res.sendRedirect("/WEB-INF/pages//trainInfo.jsp");
    }
*/

}
