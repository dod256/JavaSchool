package main.java.Entities;

import org.joda.time.DateTime;

public class Train {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartureStation() {
        return departureStation;
    }

    public int getArrivalStation() {
        return arrivalStation;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public int getCost() {
        return cost;
    }

    private int id;
    private String name;
    private int departureStation;
    private int arrivalStation;
    private DateTime departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int cost;


    //ToDo create Builder
    public Train(int id, String name, int departureStation, int arrivalStation, DateTime departureDate, int numberOfSeats, int cost) {
        this.id = id;
        this.name = name;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.numberOfSeats = numberOfSeats;
        this.numberOfFreeSeats = this.numberOfSeats;
        this.cost = cost;
    }
}
