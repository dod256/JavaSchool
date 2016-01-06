package chuggaChugga.controller;

import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.StationService;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class StationManagerController {

    @Autowired
    StationService stationService;


    @RequestMapping(value = "/setAddStationAction.form", method = RequestMethod.POST)
    public String addAction(
            @RequestParam("firstStation") String firstStation,
            @RequestParam("secondStation") String secondStation,
            @RequestParam("distance") String distance,
            HttpSession session) {
        //ToDo: Create a DistanceStationDto and update
        session.setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Distance changed"));
        return "showMessage";
    }

    @RequestMapping(value = "/setAddStationAction.form", method = RequestMethod.POST)
    public String addAction(@RequestParam("stationManagerAction") String stationManagerAction, HttpSession session) {
        session.setAttribute("stationManagerAction", stationManagerAction);
        return "stationManager";
    }

    @RequestMapping(value = "/setShowAllStationsAction.form", method = RequestMethod.POST)
    public String showAllAction(@RequestParam("stationManagerAction") String stationManagerAction, HttpSession session) {
        session.setAttribute("stationList", stationService.getAllStations());
        session.setAttribute("stationManagerAction", stationManagerAction);
        return "stationManager";
    }

    @RequestMapping(value = "/addStation.form", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, HttpSession session) {
        OperationResultMessage message = ValidatorImpl.checkName(name);
        if (message.getStatus().equals("danger")) {
            session.setAttribute("operationResultMessage", message);
        } else {
            stationService.addStation(StationDataSet.newBuilder().withName(name).build());
            session.setAttribute("operationResultMessage",
                    new OperationResultMessage("success", "StationDataSet added"));
        }
        return "showMessage";
    }

    @RequestMapping(value = "/showStationInfo.form", method = RequestMethod.POST)
    public String showInfo(@RequestParam("stationId") String stationId, HttpSession session) {
        session.setAttribute("station", stationService.getStation(Integer.parseInt(stationId)));
        //ToDo: add distanceList via session.setAttribute("distanceList", object);
        return "stationInfo";
    }

    @RequestMapping(value = "/showStationTimetable.form", method = RequestMethod.POST)
    public String showTimetable(@RequestParam("name") String name, @RequestParam("date") String dateString, HttpSession session) {
        StationDataSet station = stationService.getStationByName(name);
        LocalDate date = LocalDate.parse(dateString);
        session.setAttribute("stationTimetable", stationService.getTimetable(station, date));
        return "stationTimetable";
    }

}
