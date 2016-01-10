package chuggaChugga.model;

import com.google.common.base.MoreObjects;
import javax.persistence.*;

/*
* Represent Timetable table from the DB
* */
@Entity
@Table(name = "Timetable")
public class TimetableDataSet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="routeStationId")
    private RouteStationDataSet routeStation;

    @ManyToOne
    @JoinColumn(name="trainId")
    private TrainDataSet train;

    private TimetableDataSet(Builder builder) {
        id = builder.id;
        routeStation = builder.routeStation;
        train = builder.train;
    }

    public TimetableDataSet() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TimetableDataSet copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.routeStation = copy.routeStation;
        builder.train = copy.train;
        return builder;
    }


    public static final class Builder {
        private int id;
        private RouteStationDataSet routeStation;
        private TrainDataSet train;

        private Builder() {
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withRouteStation(RouteStationDataSet val) {
            routeStation = val;
            return this;
        }

        public Builder withTrain(TrainDataSet val) {
            train = val;
            return this;
        }

        public TimetableDataSet build() {
            return new TimetableDataSet(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RouteStationDataSet getRouteStation() {
        return routeStation;
    }

    public void setRouteStation(RouteStationDataSet routeStation) {
        this.routeStation = routeStation;
    }

    public TrainDataSet getTrain() {
        return train;
    }

    public void setTrain(TrainDataSet train) {
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
