package chuggaChugga.domain;

import com.google.common.base.MoreObjects;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.sql.Date;

/*
* Represent Train table from the DB
* */
@Entity
@Table(name = "Train")
public class TrainDataSet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="departureStation")
    private RouteStationDataSet departureStation;

    @ManyToOne
    @JoinColumn(name="arrivalStation")
    private RouteStationDataSet arrivalStation;

    private Date departureDate;
    private int numberOfSeats;
    private int numberOfFreeSeats;
    private int routeId;
    private int cost;

    private TrainDataSet(Builder builder) {
        arrivalStation = builder.arrivalStation;
        id = builder.id;
        name = builder.name;
        departureStation = builder.departureStation;
        LocalDate date = builder.departureDate;
        departureDate = Date.valueOf(date.toString());
        numberOfSeats = builder.numberOfSeats;
        numberOfFreeSeats = builder.numberOfFreeSeats;
        cost = builder.cost;
        routeId = builder.routeId;
    }

    public TrainDataSet() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainDataSet copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.id = copy.id;
        builder.name = copy.name;
        builder.departureStation = copy.departureStation;
        builder.departureDate = new LocalDate(copy.departureDate);
        builder.numberOfSeats = copy.numberOfSeats;
        builder.numberOfFreeSeats = copy.numberOfFreeSeats;
        builder.cost = copy.cost;
        builder.routeId = copy.routeId;
        return builder;
    }


    public static final class Builder {
        private RouteStationDataSet arrivalStation;
        private int id;
        private String name;
        private RouteStationDataSet departureStation;
        private LocalDate departureDate;
        private int numberOfSeats;
        private int numberOfFreeSeats;
        private int cost;
        private int routeId;

        private Builder() {
        }

        public Builder withArrivalStation(RouteStationDataSet val) {
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

        public Builder withRouteId(int val) {
            routeId = val;
            return this;
        }

        public Builder withDepartureStation(RouteStationDataSet val) {
            departureStation = val;
            return this;
        }

        public Builder withDepartureDate(LocalDate val) {
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

        public TrainDataSet build() {
            return new TrainDataSet(this);
        }
    }

    public RouteStationDataSet getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(RouteStationDataSet arrivalStation) {
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

    public RouteStationDataSet getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(RouteStationDataSet departureStation) {
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

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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
                .add("routeId", routeId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainDataSet that = (TrainDataSet) o;

        if (id != that.id) return false;
        if (numberOfSeats != that.numberOfSeats) return false;
        if (numberOfFreeSeats != that.numberOfFreeSeats) return false;
        if (routeId != that.routeId) return false;
        if (cost != that.cost) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (departureStation != null ? !departureStation.equals(that.departureStation) : that.departureStation != null)
            return false;
        if (arrivalStation != null ? !arrivalStation.equals(that.arrivalStation) : that.arrivalStation != null)
            return false;
        return !(departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (departureStation != null ? departureStation.hashCode() : 0);
        result = 31 * result + (arrivalStation != null ? arrivalStation.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + numberOfSeats;
        result = 31 * result + numberOfFreeSeats;
        result = 31 * result + routeId;
        result = 31 * result + cost;
        return result;
    }
}
