package chuggaChugga.model;

import chuggaChugga.dto.StationDistanceDto;

import javax.persistence.*;
import java.io.Serializable;
/*
* Represent User table from the DB
* */

@Entity
@Table(name = "StationDistance")
public class StationDistanceDataSet implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     int id;

     @ManyToOne
     @JoinColumn(name="firstStation")
     StationDataSet firstStation;

     @ManyToOne
     @JoinColumn(name="secondStation")
     StationDataSet secondStation;

     @Column(name = "distance")
     int distance;

     private StationDistanceDataSet(Builder builder) {
          id = builder.id;
          firstStation = builder.firstStation;
          secondStation = builder.secondStation;
          distance = builder.distance;
     }

     public StationDistanceDataSet() {
     }

     public static Builder newBuilder() {
          return new Builder();
     }

     public static Builder newBuilderReverse(StationDistanceDataSet copy) {
          Builder builder = new Builder();
          builder.id = copy.id;
          builder.firstStation = copy.secondStation;
          builder.secondStation = copy.firstStation;
          builder.distance = copy.distance;
          return builder;
     }


     public static final class Builder {
          private int id;
          private StationDataSet firstStation;
          private StationDataSet secondStation;
          private int distance;

          private Builder() {
          }

          public Builder withId(int val) {
               id = val;
               return this;
          }

          public Builder withFirstStation(StationDataSet val) {
               firstStation = val;
               return this;
          }

          public Builder withSecondStation(StationDataSet val) {
               secondStation = val;
               return this;
          }

          public Builder withDistance(int val) {
               distance = val;
               return this;
          }

          public StationDistanceDataSet build() {
               return new StationDistanceDataSet(this);
          }
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public StationDataSet getFirstStation() {
          return firstStation;
     }

     public void setFirstStation(StationDataSet firstStation) {
          this.firstStation = firstStation;
     }

     public StationDataSet getSecondStation() {
          return secondStation;
     }

     public void setSecondStation(StationDataSet secondStation) {
          this.secondStation = secondStation;
     }

     public int getDistance() {
          return distance;
     }

     public void setDistance(int distance) {
          this.distance = distance;
     }
}
