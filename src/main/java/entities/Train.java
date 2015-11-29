package main.java.Entities;

import org.joda.time.DateTime;

public class Train {

    private int id;
    private String name;
    private int departureStation;
    private int arrivalStation;
    private DateTime departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int cost;

    private Train(Builder builder) {
        arrivalStation = builder.arrivalStation;
        id = builder.id;
        name = builder.name;
        departureStation = builder.departureStation;
        departureDate = builder.departureDate;
        numberOfSeats = builder.numberOfSeats;
        numberOfFreeSeats = builder.numberOfFreeSeats;
        cost = builder.cost;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Train copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.id = copy.id;
        builder.name = copy.name;
        builder.departureStation = copy.departureStation;
        builder.departureDate = copy.departureDate;
        builder.numberOfSeats = copy.numberOfSeats;
        builder.numberOfFreeSeats = copy.numberOfFreeSeats;
        builder.cost = copy.cost;
        return builder;
    }


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

    public static final class Builder {
        private int arrivalStation;
        private int id;
        private String name;
        private int departureStation;
        private DateTime departureDate;
        private int numberOfSeats;
        private int numberOfFreeSeats;
        private int cost;

        private Builder() {
        }

        public Builder withArrivalStation(int val) {
            arrivalStation = val;
            return this;
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDepartureStation(int val) {
            departureStation = val;
            return this;
        }

        public Builder withDepartureDate(DateTime val) {
            departureDate = val;
            return this;
        }

        public Builder withNumberOfSeats(int val) {
            numberOfSeats = val;
            return this;
        }

        public Builder withNumberOfFreeSeats(int val) {
            numberOfFreeSeats = val;
            return this;
        }

        public Builder withCost(int val) {
            cost = val;
            return this;
        }

        public Train build() {
            return new Train(this);
        }
    }
}
