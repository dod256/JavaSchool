package chuggaChugga.data;

import chuggaChugga.dto.TrainDto;
import chuggaChugga.model.TrainDataSet;
import com.google.common.base.MoreObjects;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class TrainArrivalTime {
    private LocalTime arrivalTime;
    private TrainDto train;

    private TrainArrivalTime(Builder builder) {
        arrivalTime = builder.arrivalTime;
        train = builder.train;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(TrainArrivalTime copy) {
        Builder builder = new Builder();
        builder.arrivalTime = copy.arrivalTime;
        builder.train = copy.train;
        return builder;
    }

    public static final class Builder {
        private LocalTime arrivalTime;
        private TrainDto train;

        private Builder() {
        }

        public Builder withArrivalTime(LocalTime val) {
            arrivalTime = val;
            return this;
        }

        public Builder withTrain(TrainDto val) {
            train = val;
            return this;
        }

        public TrainArrivalTime build() {
            return new TrainArrivalTime(this);
        }
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() { return arrivalTime.toString(DateTimeFormat.shortTime()); }

    public TrainDto getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrivalTime", arrivalTime)
                .add("train", train)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainArrivalTime that = (TrainArrivalTime) o;

        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        return !(train != null ? !train.equals(that.train) : that.train != null);

    }

    @Override
    public int hashCode() {
        int result = arrivalTime != null ? arrivalTime.hashCode() : 0;
        result = 31 * result + (train != null ? train.hashCode() : 0);
        return result;
    }
}
