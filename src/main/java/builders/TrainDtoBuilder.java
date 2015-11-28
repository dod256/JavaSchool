package main.java.builders;

import main.java.dto.TrainDto;
import org.joda.time.DateTime;

public class TrainDtoBuilder {
    private String name;
    private String departureStation;
    private String arrivalStation;
    private DateTime departureTime;
    private DateTime arrivalTime;
    private int numberOfSeats;

    public TrainDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TrainDtoBuilder setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return this;
    }

    public TrainDtoBuilder setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return this;
    }

    public TrainDtoBuilder setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public TrainDtoBuilder setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public TrainDtoBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public TrainDto createTrainDto() {
        return new TrainDto(name, departureStation, arrivalStation, departureTime, arrivalTime, numberOfSeats);
    }
}