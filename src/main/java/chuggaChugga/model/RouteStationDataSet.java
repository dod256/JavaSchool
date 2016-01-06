package chuggaChugga.model;

import com.google.common.base.MoreObjects;
import javax.persistence.*;
import java.sql.Time;

/*
* Represent RouteStation table from the DB
* */
@Entity
@Table(name = "RouteStation")
public class RouteStationDataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="stationId")
    private StationDataSet station;
    private int stationNumber;
    private int routeId;
    private int dayCount;
    private Time arrival;
    private Time waitingTime;
    private Time onWheel;

    public RouteStationDataSet(){}

    private RouteStationDataSet(Builder builder) {
        arrival = builder.arrival;
        id = builder.id;
        station = builder.station;
        stationNumber = builder.stationNumber;
        routeId = builder.routeId;
        waitingTime = builder.waitingTime;
        onWheel = builder.onWheel;
        dayCount = builder.dayCount;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RouteStationDataSet copy) {
        Builder builder = new Builder();
        builder.arrival = copy.arrival;
        builder.id = copy.id;
        builder.station = copy.station;
        builder.stationNumber = copy.stationNumber;
        builder.routeId = copy.routeId;
        builder.waitingTime = copy.waitingTime;
        builder.onWheel = copy.onWheel;
        builder.dayCount = copy.dayCount;
        return builder;
    }


    public static final class Builder {
        private Time arrival;
        private int id;
        private StationDataSet station;
        private int stationNumber;
        private int routeId;
        private Time waitingTime;
        private Time onWheel;
        private int dayCount;

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

        public Builder withDayCount(int val) {
            dayCount = val;
            return this;
        }

        public Builder withOnWheel(Time val) {
            onWheel = val;
            return this;
        }

        public Builder withStation(StationDataSet val) {
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

        public Builder withWaitingTime(Time val) {
            waitingTime = val;
            return this;
        }

        public RouteStationDataSet build() {
            return new RouteStationDataSet(this);
        }
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public Time getOnWheel() {return onWheel;}

    public void setOnWheel() {this.onWheel = onWheel;}

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

    public StationDataSet getStation() {
        return station;
    }

    public void setStation(StationDataSet station) {
        this.station = station;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public Time getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Time waitingTime) {
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
                .add("onWheel", onWheel)
                .add("dayCount", dayCount)
                .toString();
    }
}
