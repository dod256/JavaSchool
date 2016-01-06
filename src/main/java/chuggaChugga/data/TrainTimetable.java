package chuggaChugga.data;

import chuggaChugga.model.StationDataSet;
import com.google.common.base.MoreObjects;
import org.joda.time.LocalDate;

import java.util.ArrayList;

public class TrainTimetable {
    private StationDataSet departureStation;
    private StationDataSet arrivalStation;
    private LocalDate departureDate;
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
        private StationDataSet arrivalStation;
        private StationDataSet departureStation;
        private LocalDate departureDate;
        private ArrayList<TrainRouteTime> trainRouteTimes;

        private Builder() {
        }

        public Builder withArrivalStation(StationDataSet val) {
            arrivalStation = val;
            return this;
        }

        public Builder withDepartureStation(StationDataSet val) {
            departureStation = val;
            return this;
        }

        public Builder withDepartureDate(LocalDate val) {
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

    public StationDataSet getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(StationDataSet arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public StationDataSet getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(StationDataSet departureStation) {
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
