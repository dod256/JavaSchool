package chuggaChugga.dto;

import chuggaChugga.domain.StationDistanceDataSet;

public class StationDistanceDto {

    private final String firstStation;
    private final String secondStation;
    private final int distance;

    private StationDistanceDto(Builder builder) {
        firstStation = builder.firstStation;
        secondStation = builder.secondStation;
        distance = builder.distance;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(StationDistanceDataSet copy) {
        Builder builder = new Builder();
        builder.firstStation = copy.getFirstStation().toString();
        builder.secondStation = copy.getSecondStation().toString();
        builder.distance = copy.getDistance();
        return builder;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public String getSecondStation() {
        return secondStation;
    }

    public int getDistance() {
        return distance;
    }

    public static final class Builder {
        private String firstStation;
        private String secondStation;
        private int distance;

        private Builder() {
        }

        public Builder withFirstStation(String val) {
            firstStation = val;
            return this;
        }

        public Builder withSecondStation(String val) {
            secondStation = val;
            return this;
        }

        public Builder withDistance(int val) {
            distance = val;
            return this;
        }

        public StationDistanceDto build() {
            return new StationDistanceDto(this);
        }
    }
}
