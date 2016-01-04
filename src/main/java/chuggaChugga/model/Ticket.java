package chuggaChugga.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/*
* Represent Ticket table from the DB
* */
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="trainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    private String arrivalStation;
    private String departureStation;

    private Ticket(Builder builder) {
        arrivalStation = builder.arrivalStation;
        id = builder.id;
        train = builder.train;
        user = builder.user;
        departureStation = builder.departureStation;
    }

    public Ticket() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Ticket copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.id = copy.id;
        builder.train = copy.train;
        builder.user = copy.user;
        builder.departureStation = copy.departureStation;
        return builder;
    }


    public static final class Builder {
        private String arrivalStation;
        private int id;
        private Train train;
        private User user;
        private String departureStation;

        private Builder() {
        }

        public Builder withArrivalStation(String val) {
            arrivalStation = val;
            return this;
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

        public Builder withDepartureStation(String val) {
            departureStation = val;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                .add("arrivalStation", arrivalStation)
                .add("id", id)
                .add("train", train)
                .add("user", user)
                .add("departureStation", departureStation)
                .toString();
    }
}
