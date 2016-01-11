package chuggaChugga.controller;

import chuggaChugga.dto.StationDistanceDto;
import chuggaChugga.helper.ResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.service.StationDistanceService;
import chuggaChugga.service.StationService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
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
                new ResultMessage("success", "Distance changed"));
        return "showMessage";
    }

    @RequestMapping(value = "/stationPagerInc.html", method = RequestMethod.POST)
    public String pagerInc(HttpSession session) {
        int pager = (int) session.getAttribute("stationPager");
        int maxPager = (int) session.getAttribute("stationMaxPager");
        if (pager < maxPager) {
            pager++;
        }
        session.setAttribute("stationPager", pager);
        return "showAllStations";
    }

    @RequestMapping(value = "/stationPagerDec.html", method = RequestMethod.POST)
    public String pagerDec(HttpSession session) {
        int pager = (int) session.getAttribute("stationPager");
        if (pager > 0) {
            pager--;
        }
        session.setAttribute("stationPager", pager);
        return "showAllStations";
    }

    @RequestMapping(value = "/createStation.form", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name, HttpSession session) {
        ResultMessage message = ValidatorImpl.checkName(name);
        if (message.getStatus().equals("danger")) {
            return "redirect:/createStation.html?invalidName";
        }
        /*
        //ToDo uncomment
        if (stationService.isAlreadyExist(name)) {
            return "redirect:/createStation.html?alreadyExist";
        }
        */
        stationService.addStation(StationDataSet.newBuilder().withName(name).build());
        session.setAttribute("operationResultMessage",
                    new ResultMessage("success", "Station created"));
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
