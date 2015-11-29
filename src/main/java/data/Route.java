package main.java.data;

import main.java.Entities.Station;

import java.util.ArrayList;

public class Route {

    private ArrayList<Station> stations;
    private int routeId;

    private Route(Builder builder) {
        routeId = builder.routeId;
        stations = builder.stations;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Route copy) {
        Builder builder = new Builder();
        builder.routeId = copy.routeId;
        builder.stations = copy.stations;
        return builder;
    }

    public static final class Builder {
        private int routeId;
        private ArrayList<Station> stations;

        private Builder() {
        }

        public Builder withRouteId(int val) {
            routeId = val;
            return this;
        }

        public Builder withStations(ArrayList<Station> val) {
            stations = val;
            return this;
        }

        public Route build() {
            return new Route(this);
        }
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public int getId() {
        return routeId;
    }

}
