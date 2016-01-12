package chuggaChugga.controller;

import chuggaChugga.dto.StationDistanceDto;
import chuggaChugga.helper.Constants;
import chuggaChugga.helper.ResultMessage;
import chuggaChugga.helper.ValidatorImpl;
import chuggaChugga.domain.StationDataSet;
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
import java.util.ArrayList;

import static chuggaChugga.helper.Constants.MAX_NUMBER_OF_ELEMENTS_ON_PAGE;

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

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/showAllStations.html", method = RequestMethod.GET)
    public String showAllStations(HttpSession session) {
        saveUserInSession(session);
        ArrayList<StationDataSet> stationFullList = stationService.getAllStationsOrderdByName();
        int length = stationFullList.size();
        session.setAttribute("stationFullList", stationFullList);
        session.setAttribute("stationPager", 0);
        session.setAttribute("stationMaxPager", (
                length / MAX_NUMBER_OF_ELEMENTS_ON_PAGE) +
                (length % MAX_NUMBER_OF_ELEMENTS_ON_PAGE == 0 ? 0 : 1));
        int n = Math.min(MAX_NUMBER_OF_ELEMENTS_ON_PAGE, stationFullList.size());
        ArrayList<StationDataSet> stationList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            stationList.add(stationFullList.get(i));
        }
        session.setAttribute("stationList", stationList);
        return "station/showAllStations";
    }

    @RequestMapping(value = "/stationPagerInc.html", method = RequestMethod.GET)
    public String pagerInc(HttpSession session) {
        int pager = (int) session.getAttribute("stationPager");
        int maxPager = (int) session.getAttribute("stationMaxPager");
        if (pager + 1 < maxPager) {
            pager++;
        }
        session.setAttribute("stationPager", pager);

        ArrayList<StationDataSet> stationFullList = (ArrayList<StationDataSet>) session.getAttribute("stationFullList");
        int n = Math.min((pager + 1) * MAX_NUMBER_OF_ELEMENTS_ON_PAGE, stationFullList.size());
        ArrayList<StationDataSet> stationList = new ArrayList<>();
        for(int i = pager * MAX_NUMBER_OF_ELEMENTS_ON_PAGE; i < n; i++) {
            stationList.add(stationFullList.get(i));
        }
        session.setAttribute("stationList", stationList);

        return "station/showAllStations";
    }

    @RequestMapping(value = "/stationPagerDec.html", method = RequestMethod.GET)
    public String pagerDec(HttpSession session) {
        int pager = (int) session.getAttribute("stationPager");
        if (pager > 0) {
            pager--;
        }
        session.setAttribute("stationPager", pager);

        ArrayList<StationDataSet> stationFullList = (ArrayList<StationDataSet>) session.getAttribute("stationFullList");
        int n = Math.min((pager + 1) * MAX_NUMBER_OF_ELEMENTS_ON_PAGE, stationFullList.size());
        ArrayList<StationDataSet> stationList = new ArrayList<>();
        for(int i = pager * MAX_NUMBER_OF_ELEMENTS_ON_PAGE; i < n; i++) {
            stationList.add(stationFullList.get(i));
        }
        session.setAttribute("stationList", stationList);

        return "station/showAllStations";
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
