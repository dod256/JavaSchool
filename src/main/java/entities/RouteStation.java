package main.java.Entities;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class RouteStation {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name="stationId")
    private Station station;
    private int stationNumber;
    private int routeId;
    private Time arrival;
    private int waitingTime;

    public RouteStation(){}

    private RouteStation(Builder builder) {
        arrival = builder.arrival;
        id = builder.id;
        station = builder.station;
        stationNumber = builder.stationNumber;
        routeId = builder.routeId;
        waitingTime = builder.waitingTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RouteStation copy) {
        Builder builder = new Builder();
        builder.arrival = copy.arrival;
        builder.id = copy.id;
        builder.station = copy.station;
        builder.stationNumber = copy.stationNumber;
        builder.routeId = copy.routeId;
        builder.waitingTime = copy.waitingTime;
        return builder;
    }


    public static final class Builder {
        private Time arrival;
        private int id;
        private Station station;
        private int stationNumber;
        private int routeId;
        private int waitingTime;

        private Builder() {
        }

        public Builder withArrival(Time val) {
            arrival = val;
            return this;
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withStation(Station val) {
            station = val;
            return this;
        }

        public Builder withStationNumber(int val) {
            stationNumber = val;
            return this;
        }

        public Builder withRouteId(int val) {
            routeId = val;
            return this;
        }

        public Builder withWaitingTime(int val) {
            waitingTime = val;
            return this;
        }

        public RouteStation build() {
            return new RouteStation(this);
        }
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrival", arrival)
                .add("id", id)
                .add("station", station)
                .add("stationNumber", stationNumber)
                .add("routeId", routeId)
                .add("waitingTime", waitingTime)
                .toString();
    }
}