package model;

import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

/*
* Represent Train table from the DB
* */
@Entity
public class Train {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="departureStation")
    private RouteStation departureStation;

    @ManyToOne
    @JoinColumn(name="arrivalStation")
    private RouteStation arrivalStation;

    private Date departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int cost;

    private Train(Builder builder) {
        arrivalStation = builder.arrivalStation;
        id = builder.id;
        name = builder.name;
        departureStation = builder.departureStation;
        DateTime date = builder.departureDate;
        departureDate = new Date(date.getMillis());
        numberOfSeats = builder.numberOfSeats;
        numberOfFreeSeats = builder.numberOfFreeSeats;
        cost = builder.cost;
    }

    public Train() {
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
        builder.departureDate = new DateTime(copy.departureDate);
        builder.numberOfSeats = copy.numberOfSeats;
        builder.numberOfFreeSeats = copy.numberOfFreeSeats;
        builder.cost = copy.cost;
        return builder;
    }


    public static final class Builder {
        private RouteStation arrivalStation;
        private int id;
        private String name;
        private RouteStation departureStation;
        private DateTime departureDate;
        private int numberOfSeats;
        private int numberOfFreeSeats;
        private int cost;

        private Builder() {
        }

        public Builder withArrivalStation(RouteStation val) {
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

        public Builder withDepartureStation(RouteStation val) {
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

    public RouteStation getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(RouteStation arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public RouteStation getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(RouteStation departureStation) {
        this.departureStation = departureStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public void setNumberOfFreeSeats(int numberOfFreeSeats) {
        this.numberOfFreeSeats = numberOfFreeSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalStation", arrivalStation)
                .add("id", id)
                .add("name", name)
                .add("departureStation", departureStation)
                .add("departureDate", departureDate)
                .add("numberOfSeats", numberOfSeats)
                .add("numberOfFreeSeats", numberOfFreeSeats)
                .add("cost", cost)
                .toString();
    }
}
