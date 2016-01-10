package chuggaChugga.controller;

import chuggaChugga.dto.StationDistanceDto;
import chuggaChugga.helper.OperationResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.model.StationDataSet;
import chuggaChugga.service.StationDistanceService;
import chuggaChugga.service.StationService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class StationController extends MyController {

    @Autowired
    StationService stationService;
    @Autowired
    StationDistanceService stationDistanceService;


    @RequestMapping(value = "/changeDistance.form", method = RequestMethod.POST)
    public String changeDistance(
            @RequestParam("firstStation") String firstStation,
            @RequestParam("secondStation") String secondStation,
            @RequestParam("distance") String distance,
            HttpSession session) {
        stationDistanceService.addOrUpdateDistance(StationDistanceDto.newBuilder()
                        .withDistance(Integer.parseInt(distance))
                        .withFirstStation(firstStation)
                        .withSecondStation(secondStation)
                        .build());
        session.setAttribute("operationResultMessage",
                new OperationResultMessage("success", "Distance changed"));
        return "showMessage";
    }

    @RequestMapping(value = "/createStation.form", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name, HttpSession session) {
        OperationResultMessage message = ValidatorImpl.checkName(name);
        if (message.getStatus().equals("danger")) {
            return "redirect:/createStation.html?error=true";
        } else {
            stationService.addStation(StationDataSet.newBuilder().withName(name).build());
            session.setAttribute("operationResultMessage",
                    new OperationResultMessage("success", "StationDataSet added"));
        }
        return "showMessage";
    }

    @RequestMapping(value = "/showStationInfo.form", method = RequestMethod.POST)
    public String showInfo(@RequestParam("stationId") String stationId, HttpSession session) {
        StationDataSet station = stationService.getStation(Integer.parseInt(stationId));
        session.setAttribute("station", station);
        session.setAttribute("distanceList", stationDistanceService.findAllDistances(station.getName()));
        return "station/stationInfo";
    }

    @RequestMapping(value = "/showStationTimetable.form", method = RequestMethod.POST)
    public String showTimetable(@RequestParam("name") String name, @RequestParam("date") String dateString, HttpSession session) {
        StationDataSet station = stationService.getStationByName(name);
        LocalDate date = LocalDate.parse(dateString);
        session.setAttribute("stationTimetable", stationService.getTimetable(station, date));
        return "station/stationTimetable";
    }

}
