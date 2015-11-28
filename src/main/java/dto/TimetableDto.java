package main.java.dto;

import org.joda.time.DateTime;

public class TimetableDto {


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

    public TimetableDto(String departureStation, String arrivalStation, DateTime date) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.date = date;
    }

}
