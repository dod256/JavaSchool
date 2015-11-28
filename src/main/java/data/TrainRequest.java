package main.java.data;

import org.joda.time.DateTime;

public class TrainRequest {


    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public DateTime getDate() {
        return date;
    }

    private String departureStation;
    private String arrivalStation;
    private DateTime date;

    public TrainRequest(String departureStation, String arrivalStation, DateTime date) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.date = date;
    }

}
