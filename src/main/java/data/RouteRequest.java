package main.java.data;

import org.joda.time.DateTime;

public class RouteRequest {
    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    private String departureStation;
    private String arrivalStation;
    private DateTime firstTime;

    public DateTime getFirstTime() {
        return firstTime;
    }

    public DateTime getSecondTime() {
        return secondTime;
    }

    private DateTime secondTime;

    public RouteRequest(String departureStation, String arrivalStation, DateTime firstTime, DateTime secondTime) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.firstTime = firstTime;
        this.secondTime = secondTime;
    }
}
