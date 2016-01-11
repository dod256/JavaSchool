package chuggaChugga.data;

import chuggaChugga.domain.StationDataSet;
import com.google.common.base.MoreObjects;
import chuggaChugga.domain.RouteStationDataSet;

import java.util.ArrayList;

public class Route {

    private ArrayList<RouteStationDataSet> routeStations;
    private ArrayList<StationDataSet> stations;
    private int routeId;

    private Route(Builder builder) {
        routeId = builder.routeId;
        routeStations = builder.routeStations;
        stations = builder.stations;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Route copy) {
        Builder builder = new Builder();
        builder.routeId = copy.routeId;
        builder.routeStations = copy.routeStations;
        builder.stations = copy.stations;
        return builder;
    }


    public static final class Builder {
        private int routeId;
        private ArrayList<RouteStationDataSet> routeStations;
        private ArrayList<StationDataSet> stations;

        private Builder() {
        }

        public Builder withRouteId(int val) {
            routeId = val;
            return this;
        }

        public Builder withRouteStations(ArrayList<RouteStationDataSet> val) {
            routeStations = val;
            return this;
        }

        public Builder withStations(ArrayList<StationDataSet> val) {
            stations = val;
            return this;
        }

        public Route build() {
            return new Route(this);
        }
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public ArrayList<RouteStationDataSet> getRouteStations() {
        return routeStations;
    }

    public void setRouteStations(ArrayList<RouteStationDataSet> routeStations) {
        this.routeStations = routeStations;
    }

    public ArrayList<StationDataSet> getStations() {
        return stations;
    }

    public void setStations(ArrayList<StationDataSet> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("routeId", routeId)
                .add("routeStations", routeStations)
                .add("stations", stations)
                .toString();
    }
}
