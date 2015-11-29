package main.java.builders;

import main.java.Entities.Train;
import main.java.data.Route;
import org.joda.time.DateTime;

public class TrainBuilder {
    private String name;
    private String departureStation;
    private String arrivalStation;
    private DateTime departureTime;
    private DateTime arrivalTime;
    private int numberOfSeats;
    private Route route;

    public TrainBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TrainBuilder setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return this;
    }

    public TrainBuilder setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return this;
    }

    public TrainBuilder setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public TrainBuilder setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public TrainBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public Train createTrain() {
        return new Train(name, departureStation, arrivalStation, departureTime, arrivalTime, numberOfSeats);
    }
}