package chuggaChugga.service;

import chuggaChugga.dao.RouteStationDao;
import chuggaChugga.data.NewRouteStation;
import chuggaChugga.domain.RouteStationDataSet;
import chuggaChugga.domain.StationDataSet;
import chuggaChugga.data.NewRouteImpl;
import chuggaChugga.data.Route;
import chuggaChugga.data.RouteRequest;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;

/*
* Implements logic connected to routes
* */

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteStationDao routeStationDao;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteStationService routeStationService;
    @Autowired
    private RouteLengthService routeLengthService;

    public void createRoute(NewRouteImpl newRouteImpl) {
        //ToDo find bug
        int routeId = routeLengthService.getFreeRouteId();
        for (NewRouteStation newRouteStation: newRouteImpl.getRouteStations()) {
            int stationNumber = 0;
            RouteStationDataSet.Builder builder = RouteStationDataSet.newBuilder();
            builder.withArrival(toSqlTime(newRouteStation.getArrivalTime()))
                   .withRouteId(routeId)
                   .withStation(stationService.getStationByName(newRouteStation.getStation()))
                   .withStationNumber(++stationNumber)
                   .withWaitingTime(toSqlTime(newRouteStation.getArrivalTime()));
            routeStationService.addRouteStation(builder.build());
        }
        routeLengthService.addRouteLength(newRouteImpl.getRouteStations().size());
    }

    private Time toSqlTime(LocalTime arrivalTime) {
        return new Time(arrivalTime.getHourOfDay(), arrivalTime.getMinuteOfHour(), arrivalTime.getMinuteOfHour());

    }

    public Route getRouteById(int routeId) {
        Route.Builder builder = Route.newBuilder();
        builder.withRouteId(routeId);
        ArrayList<RouteStationDataSet> routeStations = (ArrayList<RouteStationDataSet>) routeStationDao.getRouteStationsById(routeId);

        routeStations.sort((o1, o2) -> o1.getStationNumber() - o2.getStationNumber());

        ArrayList<StationDataSet> stations = new ArrayList<StationDataSet>();
        for (RouteStationDataSet routeStation: routeStations) {
            stations.add(routeStation.getStation());
        }
        return builder.withStations(stations).withRouteStations(routeStations).build();
    }

    public ArrayList<Route> getAllRoutes() {
        ArrayList<Route> routes = new ArrayList<Route>();
        ArrayList<RouteStationDataSet> allRouteStations = (ArrayList<RouteStationDataSet>) routeStationDao.getAllRouteStations();

        allRouteStations.sort((o1, o2) -> {
            if (o1.getRouteId() == o2.getRouteId()) {
                return o1.getStationNumber() - o2.getStationNumber();
            } else {
                return o1.getRouteId() - o2.getRouteId();
            }
        });

        Route.Builder routeBuilder = Route.newBuilder().withRouteId(allRouteStations.get(0).getRouteId());
        ArrayList<StationDataSet> stations = new ArrayList<StationDataSet>();
        ArrayList<RouteStationDataSet> routeStations = new ArrayList<RouteStationDataSet>();
        stations.add(allRouteStations.get(0).getStation());
        routeStations.add(allRouteStations.get(0));
        for (int i = 1; i < allRouteStations.size(); i++) {
            RouteStationDataSet currentRouteStation = allRouteStations.get(i);
            if (currentRouteStation.getRouteId() != allRouteStations.get(i - 1).getRouteId()) {
                routes.add(routeBuilder
                        .withStations(stations)
                        .withRouteStations(routeStations)
                        .build());
                stations = new ArrayList<>();
                routeStations = new ArrayList<>();
                routeBuilder.withRouteId(currentRouteStation.getRouteId());
            }
            stations.add(currentRouteStation.getStation());
            routeStations.add(currentRouteStation);
        }

        routes.add(routeBuilder.withStations(stations).withRouteStations(routeStations).build());
        return routes;
    }

    public ArrayList<Route> getRoutes(RouteRequest request) {
        ArrayList<Route> result = new ArrayList<Route>();
        ArrayList<Route> allRoute = getAllRoutes();
        for (Route route: allRoute) {
            boolean hasDepartureStation = false;
            boolean hasArrivalStation = false;
            for (StationDataSet station: route.getStations()) {
                if (station.getName().equals(request.getArrivalStation())) {
                    hasArrivalStation = true;
                }
                if (station.getName().equals(request.getDepartureStation())) {
                    hasDepartureStation = true;
                }
            }
            if (hasArrivalStation && hasDepartureStation) {
                result.add(route);
            }
        }
        return result;
    }

}
