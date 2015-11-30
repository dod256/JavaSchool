package main.java.Entities;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="trainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    private int routeNumberOfArrivalStation;
    private int routeNumberOfDepartureStation;

    private Ticket(Builder builder) {
        id = builder.id;
        train = builder.train;
        user = builder.user;
        routeNumberOfArrivalStation = builder.routeNumberOfArrivalStation;
        routeNumberOfDepartureStation = builder.routeNumberOfDepartureStation;
    }

    public Ticket() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Ticket copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.train = copy.train;
        builder.user = copy.user;
        builder.routeNumberOfArrivalStation = copy.routeNumberOfArrivalStation;
        builder.routeNumberOfDepartureStation = copy.routeNumberOfDepartureStation;
        return builder;
    }


    public static final class Builder {
        private int id;
        private Train train;
        private User user;
        private int routeNumberOfArrivalStation;
        private int routeNumberOfDepartureStation;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withTrain(Train val) {
            train = val;
            return this;
        }

        public Builder withUser(User val) {
            user = val;
            return this;
        }

        public Builder withRouteNumberOfArrivalStation(int val) {
            routeNumberOfArrivalStation = val;
            return this;
        }

        public Builder withRouteNumberOfDepartureStation(int val) {
            routeNumberOfDepartureStation = val;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteNumberOfArrivalStation() {
        return routeNumberOfArrivalStation;
    }

    public void setRouteNumberOfArrivalStation(int routeNumberOfArrivalStation) {
        this.routeNumberOfArrivalStation = routeNumberOfArrivalStation;
    }

    public int getRouteNumberOfDepartureStation() {
        return routeNumberOfDepartureStation;
    }

    public void setRouteNumberOfDepartureStation(int routeNumberOfDepartureStation) {
        this.routeNumberOfDepartureStation = routeNumberOfDepartureStation;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("train", train)
                .add("user", user)
                .add("routeNumberOfArrivalStation", routeNumberOfArrivalStation)
                .add("routeNumberOfDepartureStation", routeNumberOfDepartureStation)
                .toString();
    }
}
