package main.java.services;

import main.java.Entities.RouteStation;
import main.java.Entities.Station;
import main.java.dao.RouteStationDao;
import main.java.data.NewRouteImpl;
import main.java.data.Route;
import main.java.data.RouteRequest;
import org.joda.time.Period;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;

/*
* Implements logic connected to routes
* */
public class RouteService extends Service {

    private static RouteStationDao routeStationDao = new RouteStationDao(em);
    
    public static void createRoute(NewRouteImpl newRouteImpl) {
        int routeId = RouteLengthService.getFreeRouteId();

        Period onWheel = new Period();
        for (int i = 0; i < newRouteImpl.getStation().size(); i++) {
            onWheel = onWheel.plusMinutes(newRouteImpl.getOnWheel().get(i));
            RouteStation.Builder builder = RouteStation.newBuilder();
            builder.withArrival(new Time(newRouteImpl.getDepartureTime().plus(onWheel).getMillis()))
                    .withOnWheel(new Time(0, onWheel.getMinutes(), 0))
                            .withRouteId(routeId)
                            .withStation(StationService.getStation(newRouteImpl.getStation().get(i)))
                            .withStationNumber(i + 1)
                            .withWaitingTime(new Time(0, new Period().plusMinutes(newRouteImpl.getWaitingTime().get(i)).getMinutes(), 0));
            RouteStationService.addRouteStation(builder.build());
            onWheel = onWheel.plusMinutes(newRouteImpl.getWaitingTime().get(i));
        }

        RouteLengthService.addRouteLength(newRouteImpl.getStation().size());
    }

    public static Route getRouteById(int routeId) {
        Route.Builder builder = Route.newBuilder();
        builder.withRouteId(routeId);
        ArrayList<RouteStation> routeStations = routeStationDao.getRouteStationsBy(routeId);

        routeStations.sort(new Comparator<RouteStation>() {
            public int compare(RouteStation o1, RouteStation o2) {
                return o1.getStationNumber() - o2.getStationNumber();
            }
        });

        ArrayList<Station> stations = new ArrayList<Station>();
        for (RouteStation routeStation: routeStations) {
            stations.add(routeStation.getStation());
        }
        return builder.withStations(stations).withRouteStations(routeStations).build();
    }

    public static ArrayList<Route> getAllRoutes() {
        ArrayList<Route> routes = new ArrayList<Route>();
        ArrayList<RouteStation> allRouteStations = routeStationDao.getAllRouteStations();

        allRouteStations.sort(new Comparator<RouteStation>() {
            public int compare(RouteStation o1, RouteStation o2) {
                if (o1.getRouteId() == o2.getRouteId()) {
                    return o1.getStationNumber() - o2.getStationNumber();
                } else {
                    return o1.getRouteId() - o2.getRouteId();
                }
            }
        });

        Route.Builder routeBuilder = Route.newBuilder().withRouteId(allRouteStations.get(0).getRouteId());
        ArrayList<Station> stations = new ArrayList<Station>();
        ArrayList<RouteStation> routeStations = new ArrayList<RouteStation>();
        stations.add(allRouteStations.get(0).getStation());
        routeStations.add(allRouteStations.get(0));
        for (int i = 1; i < allRouteStations.size(); i++) {
            RouteStation currentRouteStation = allRouteStations.get(i);
            if (currentRouteStation.getRouteId() != allRouteStations.get(i - 1).getRouteId()) {
                routes.add(routeBuilder
                        .withStations(stations)
                        .withRouteStations(routeStations)
                        .build());
                stations = new ArrayList<Station>();
                routeStations = new ArrayList<RouteStation>();
                routeBuilder.withRouteId(currentRouteStation.getRouteId());
            }
            stations.add(currentRouteStation.getStation());
            routeStations.add(currentRouteStation);
        }

        routes.add(routeBuilder.withStations(stations).withRouteStations(routeStations).build());
        return routes;
    }

    public static ArrayList<Route> getRoutes(RouteRequest request) {
        ArrayList<Route> result = new ArrayList<Route>();
        ArrayList<Route> allRoute = getAllRoutes();
        for (Route route: allRoute) {
            boolean hasDepartureStation = false;
            boolean hasArrivalStation = false;
            for (Station station: route.getStations()) {
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
