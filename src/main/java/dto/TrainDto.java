package main.java.dto;

import org.joda.time.DateTime;

public class TrainDto {

    private String name;
    private String departureStation;
    private String arrivalStation;
    private DateTime departureTime;
    private DateTime arrivalTime;
    private int numberOfSeats;
    private int numberOfFreeSeats;

    public String getName() {
        return name;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public String getDepartureTime() {
        return departureTime.toString();
    }

    public String getArrivalTime() {
        return arrivalTime.toString();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public TrainDto(String name, String departureStation, String arrivalStation, DateTime departureTime, DateTime arrivalTime, int numberOfSeats) {
        this.name = name;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.numberOfSeats = numberOfSeats;
        this.numberOfFreeSeats = this.numberOfSeats;
    }
}
