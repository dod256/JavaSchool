package chuggaChugga.controller;

import chuggaChugga.data.*;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.dto.TrainDto;
import chuggaChugga.dto.UserDto;
import chuggaChugga.helper.Constants;
import chuggaChugga.helper.ResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.domain.RouteStationDataSet;
import chuggaChugga.domain.TrainDataSet;
import chuggaChugga.service.RouteService;
import chuggaChugga.service.StationService;
import chuggaChugga.service.TicketService;
import chuggaChugga.service.TrainService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static chuggaChugga.helper.Constants.MAX_NUMBER_OF_ELEMENTS_ON_PAGE;

@Controller
public class TrainController extends MyController {

    @Autowired
    TrainService trainService;

    @Autowired
    TicketService ticketService;

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/addRouteToTrain.form", method = RequestMethod.POST)
    public String addRoute(@RequestParam("routeId") String routeId, HttpSession session) {
        ResultMessage message =
                ValidatorImpl.checkNumber(routeId);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int id = Integer.parseInt(routeId);
        Route route =
                routeService.getRouteById(id);
        TrainDataSet.Builder trainBuilder = (TrainDataSet.Builder)
                session.getAttribute("trainBuilder");
        ArrayList<RouteStationDataSet> routeStations =
                route.getRouteStations();
        trainBuilder = trainBuilder
                .withRouteId(id)
                .withDepartureStation(routeStations.get(0))
                .withArrivalStation(routeStations
                        .get(routeStations.size() - 1));

        TrainRoute trainRoute = TrainRoute.newBuilder()
                .withTrain(trainBuilder.build())
                .withRoute(route)
                .build();
        trainService.createTrain(trainRoute);

        session.setAttribute("operationResultMessage",
                new ResultMessage("success", "Train created"));
        return "showMessage";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllTrains.html", method = RequestMethod.GET)
    public String showAllTrains(HttpSession session) {
        saveUserInSession(session);
        ArrayList<TrainDto> trainFullList = trainService.getAllTrains();
        int length = trainFullList.size();
        session.setAttribute("trainFullList", trainFullList);
        session.setAttribute("trainPager", 0);
        session.setAttribute("trainMaxPager", (
                length / MAX_NUMBER_OF_ELEMENTS_ON_PAGE) +
                (length % MAX_NUMBER_OF_ELEMENTS_ON_PAGE == 0 ? 0 : 1));
        int n = Math.min(MAX_NUMBER_OF_ELEMENTS_ON_PAGE, trainFullList.size());
        ArrayList<TrainDto> trainList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            trainList.add(trainFullList.get(i));
        }
        session.setAttribute("trainList", trainList);
        return "train/showAllTrains";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/trainPagerInc.html", method = RequestMethod.GET)
    public String pagerInc(HttpSession session) {
        int pager = (int) session.getAttribute("trainPager");
        int maxPager = (int) session.getAttribute("trainMaxPager");
        if (pager + 1 < maxPager) {
            pager++;
        }
        session.setAttribute("trainPager", pager);

        ArrayList<TrainDto> trainFullList = (ArrayList<TrainDto>) session.getAttribute("trainFullList");
        int n = Math.min((pager + 1) * MAX_NUMBER_OF_ELEMENTS_ON_PAGE, trainFullList.size());
        ArrayList<TrainDto> trainList = new ArrayList<>();
        for(int i = pager * MAX_NUMBER_OF_ELEMENTS_ON_PAGE; i < n; i++) {
            trainList.add(trainFullList.get(i));
        }
        session.setAttribute("trainList", trainList);
        return "train/showAllTrains";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/trainPagerDec.html", method = RequestMethod.GET)
    public String pagerDec(HttpSession session) {
        int pager = (int) session.getAttribute("trainPager");
        if (pager > 0) {
            pager--;
        }
        session.setAttribute("trainPager", pager);

        ArrayList<TrainDto> trainFullList = (ArrayList<TrainDto>) session.getAttribute("trainFullList");
        int n = Math.min((pager + 1) * MAX_NUMBER_OF_ELEMENTS_ON_PAGE, trainFullList.size());
        ArrayList<TrainDto> trainList = new ArrayList<>();
        for(int i = pager * MAX_NUMBER_OF_ELEMENTS_ON_PAGE; i < n; i++) {
            trainList.add(trainFullList.get(i));
        }
        session.setAttribute("trainList", trainList);
        return "train/showAllTrains";

    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllRoutesForTrain.form", method = RequestMethod.POST)
    public String showAllRoutes(HttpSession session) {
        ArrayList<Route> routeList = routeService.getAllRoutes();
        session.setAttribute("routeList", routeList);
        return "train/addRouteToTrain";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showRoutesForTrain.form", method = RequestMethod.POST)
    public String showRoutes(
            @RequestParam("departureStation") String departureStation,
            @RequestParam("arrivalStation") String arrivalStation,
            HttpSession session) {
        RouteRequest request = RouteRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .build();
        ArrayList<Route> routeList = routeService.getRoutes(request);

        session.setAttribute("routeList", routeList);
        return "train/addRouteToTrain";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showPassengers.form", method = RequestMethod.POST)
    public String showPassengers(@RequestParam("trainId") String trainIdString, HttpSession session) {
        int trainId = Integer.parseInt(trainIdString);
        ArrayList<UserDto> passengerList = trainService.getPassengers(trainId);
        session.setAttribute("passengerList", passengerList);
        return "train/showPassengers";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/addTrain.form", method = RequestMethod.POST)
    public String addTrain(
            @RequestParam("date") String dateString,
            @RequestParam("cost") String costString,
            @RequestParam("name") String name,
            @RequestParam("numberOfSeats") String numberOfSeatsString,
            HttpSession session) {
        ResultMessage message = ValidatorImpl.checkDate(dateString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        LocalDate date = LocalDate.parse(dateString);
        message = ValidatorImpl.checkNumber(numberOfSeatsString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int numberOfSeats = Integer.parseInt(numberOfSeatsString);
        message = ValidatorImpl.checkNumber(costString);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }
        int cost = Integer.parseInt(costString);

        message = ValidatorImpl.generalCheck(name);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
            return "showMessage";
        }

        TrainDataSet.Builder trainBuilder = TrainDataSet.newBuilder().withCost(cost)
                .withNumberOfSeats(numberOfSeats)
                .withNumberOfFreeSeats(numberOfSeats)
                .withDepartureDate(date)
                .withName(name);
        session.setAttribute("trainBuilder", trainBuilder);
        session.setAttribute("stationList", stationService.getAllStations());
        return "train/addRouteToTrain";
    }

    @RequestMapping(value = "/findTrainTimetable.form", method = RequestMethod.POST)
    public String findTrainTimetable(
            @RequestParam("departureStation") String departureStation,
            @RequestParam("arrivalStation") String arrivalStation,
            @RequestParam("date") String dateString,
            HttpSession session) {
        session.setAttribute("departureStation", departureStation);
        session.setAttribute("arrivalStation", arrivalStation);
        LocalDate date = LocalDate.parse(dateString);
        TrainRequest trainRequest = TrainRequest.newBuilder()
                .withDepartureStation(departureStation)
                .withArrivalStation(arrivalStation)
                .withDate(date)
                .build();
        TrainTimetable trainTimetable = trainService.getTrains(trainRequest);
        session.setAttribute("trainTimetable", trainTimetable);
        return "train/trainTimetable";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/purchaseTicket.form", method = RequestMethod.POST)
    public String purchaseTicket(
            @RequestParam("trainId") String trainIdString,
            HttpSession session) {
        saveUserInSession(session);

        int trainId = Integer.parseInt(trainIdString);

       TicketRequest ticketRequest = TicketRequest.newBuilder()
                .withTrain(trainService.getTrain(trainId))
                .withUser((UserDto) session.getAttribute("currentUser"))
                .withArrivalStation((String) session.getAttribute("arrivalStation"))
                .withDepartureStation((String) session.getAttribute("departureStation"))
                .build();
        boolean tryToBuy = ticketService.tryToPurchaseTicket(ticketRequest);

        if (tryToBuy) {
            session.setAttribute("operationResultMessage", new ResultMessage("success", "Ticket purhased"));
        } else {
            session.setAttribute("operationResultMessage", new ResultMessage("danger", "Couldn't purhase ticket"));
        }
        saveUserInSession(session);
        return "showMessage";
    }
}
