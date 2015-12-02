package main.java.data;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class NewRoute {
    private DateTime departureTime;
    private ArrayList<String> station;
    private ArrayList<Integer> onWheel;
    private ArrayList<Integer> waitingTime;

    private NewRoute(Builder builder) {
        departureTime = builder.departureTime;
        station = builder.station;
        onWheel = builder.onWheel;
        waitingTime = builder.waitingTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(NewRoute copy) {
        Builder builder = new Builder();
        builder.departureTime = copy.departureTime;
        builder.station = copy.station;
        builder.onWheel = copy.onWheel;
        builder.waitingTime = copy.waitingTime;
        return builder;
    }


    public static final class Builder {
        private DateTime departureTime;
        private ArrayList<String> station;
        private ArrayList<Integer> onWheel;
        private ArrayList<Integer> waitingTime;

        private Builder() {
        }

        public Builder withDepartureTime(DateTime val) {
            departureTime = val;
            return this;
        }

        public Builder withStation(ArrayList<String> val) {
            station = val;
            return this;
        }

        public Builder withOnWheel(ArrayList<Integer> val) {
            onWheel = val;
            return this;
        }

        public Builder withWaitingTime(ArrayList<Integer> val) {
            waitingTime = val;
            return this;
        }

        public NewRoute build() {
            return new NewRoute(this);
        }
    }

    public DateTime getDepartureTime() {
        return departureTime;
    }

    public ArrayList<Integer> getOnWheel() {
        return onWheel;
    }

    public ArrayList<String> getStation() {
        return station;
    }

    public ArrayList<Integer> getWaitingTime() {
        return waitingTime;
    }
}
