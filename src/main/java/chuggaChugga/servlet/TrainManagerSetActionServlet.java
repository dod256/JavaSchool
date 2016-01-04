package chuggaChugga.servlet;

import javax.servlet.http.HttpServlet;

public class TrainManagerSetActionServlet extends HttpServlet {
/*
    @Autowired
    TrainService trainService;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        if (actionType.equals("delete")) {
            ArrayList<TrainDataSet> trainList = trainService.getAllTrains();
            ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
            for(TrainDataSet train : trainList) {
                trainDtoList.add(new TrainDto(train, RouteServiceImpl.getRouteById(train.getDepartureStation().getRouteId())));
            }

            req.getSession().setAttribute("actionObjectList", trainDtoList);
        }

        if (actionType.equals("showAll")) {
            ArrayList<TrainDataSet> trainList = trainService.getAllTrains();
            ArrayList<TrainDto> trainDtoList = new ArrayList<TrainDto>();
            for(TrainDataSet train : trainList) {
                trainDtoList.add(new TrainDto(train, RouteServiceImpl.getRouteById(train.getDepartureStation().getRouteId())));
            }

            req.getSession().setAttribute("actionObjectList", trainDtoList);
        }

        req.getSession().setAttribute("currentManagerAction", actionType);
        res.sendRedirect("/WEB-INF/pages/trainManager.jsp");
    }*/
}
