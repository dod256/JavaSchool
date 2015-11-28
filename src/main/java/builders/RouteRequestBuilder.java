package main.java.builders;

import main.java.data.RouteRequest;
import org.joda.time.DateTime;

public class RouteRequestBuilder {
    private String departureStation;
    private String arrivalStation;
    private DateTime firstTime;
    private DateTime secondTime;

    public RouteRequestBuilder setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return this;
    }

    public RouteRequestBuilder setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return this;
    }

    public RouteRequestBuilder setFirstTime(DateTime firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public RouteRequestBuilder setSecondTime(DateTime secondTime) {
        this.secondTime = secondTime;
        return this;
    }

    public RouteRequest createRouteRequest() {
        return new RouteRequest(departureStation, arrivalStation, firstTime, secondTime);
    }
}