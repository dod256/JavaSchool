package model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/*
* Represent Timetable table from the DB
* */
@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="routeStationId")
    private RouteStation routeStation;

    @ManyToOne
    @JoinColumn(name="trainId")
    private Train train;

    private Timetable(Builder builder) {
        id = builder.id;
        routeStation = builder.routeStation;
        train = builder.train;
    }

    public Timetable() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Timetable copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.routeStation = copy.routeStation;
        builder.train = copy.train;
        return builder;
    }


    public static final class Builder {
        private int id;
        private RouteStation routeStation;
        private Train train;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withRouteStation(RouteStation val) {
            routeStation = val;
            return this;
        }

        public Builder withTrain(Train val) {
            train = val;
            return this;
        }

        public Timetable build() {
            return new Timetable(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RouteStation getRouteStation() {
        return routeStation;
    }

    public void setRouteStation(RouteStation routeStation) {
        this.routeStation = routeStation;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("routeStation", routeStation)
                .add("train", train)
                .toString();
    }
}
