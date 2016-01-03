package chuggaChugga.data;

import com.google.common.base.MoreObjects;
import chuggaChugga.model.Station;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class TrainTimetable {
    private Station departureStation;
    private Station arrivalStation;
    private DateTime departureDate;
    private ArrayList<TrainRouteTime> trainRouteTimes;

    private TrainTimetable(Builder builder) {
        arrivalStation = builder.arrivalStation;
        departureStation = builder.departureStation;
        departureDate = builder.departureDate;
        trainRouteTimes = builder.trainRouteTimes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainTimetable copy) {
        Builder builder = new Builder();
        builder.arrivalStation = copy.arrivalStation;
        builder.departureStation = copy.departureStation;
        builder.departureDate = copy.departureDate;
        builder.trainRouteTimes = copy.trainRouteTimes;
        return builder;
    }


    public static final class Builder {
        private Station arrivalStation;
        private Station departureStation;
        private DateTime departureDate;
        private ArrayList<TrainRouteTime> trainRouteTimes;

        private Builder() {
        }

        public Builder withArrivalStation(Station val) {
            arrivalStation = val;
            return this;
        }

        public Builder withDepartureStation(Station val) {
            departureStation = val;
            return this;
        }

        public Builder withDepartureDate(DateTime val) {
            departureDate = val;
            return this;
        }

        public Builder withTrainRouteTimes(ArrayList<TrainRouteTime> val) {
            trainRouteTimes = val;
            return this;
        }

        public TrainTimetable build() {
            return new TrainTimetable(this);
        }
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public DateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public ArrayList<TrainRouteTime> getTrainRouteTimes() {
        return trainRouteTimes;
    }

    public void setTrainRouteTimes(ArrayList<TrainRouteTime> trainRouteTimes) {
        this.trainRouteTimes = trainRouteTimes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalStation", arrivalStation)
                .add("departureStation", departureStation)
                .add("departureDate", departureDate)
                .add("trainRouteTimes", trainRouteTimes)
                .toString();
    }
}
