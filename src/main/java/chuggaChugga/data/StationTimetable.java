package chuggaChugga.data;

import chuggaChugga.model.StationDataSet;
import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

public class StationTimetable {
    private StationDataSet station;
    private DateTime date;
    private ArrayList<TrainArrivalTime> trainArrivalTimes;

    private StationTimetable(Builder builder) {
        date = builder.date;
        station = builder.station;
        trainArrivalTimes = builder.trainArrivalTimes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(StationTimetable copy) {
        Builder builder = new Builder();
        builder.date = copy.date;
        builder.station = copy.station;
        builder.trainArrivalTimes = copy.trainArrivalTimes;
        return builder;
    }


    public static final class Builder {
        private DateTime date;
        private StationDataSet station;
        private ArrayList<TrainArrivalTime> trainArrivalTimes;

        private Builder() {
        }

        public Builder withDate(DateTime val) {
            date = val;
            return this;
        }

        public Builder withStation(StationDataSet val) {
            station = val;
            return this;
        }

        public Builder withTrainArrivalTimes(ArrayList<TrainArrivalTime> val) {
            trainArrivalTimes = val;
            return this;
        }

        public StationTimetable build() {
            return new StationTimetable(this);
        }
    }

    public DateTime getDate() {
        return date;
    }

    public String getDateString() {
        return date.toString(DateTimeFormat.longDate());
    }

    public StationDataSet getStation() {
        return station;
    }

    public ArrayList<TrainArrivalTime> getTrainArrivalTimes() {
        return trainArrivalTimes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("station", station)
                .add("trainArrivalTimes", trainArrivalTimes)
                .toString();
    }
}
