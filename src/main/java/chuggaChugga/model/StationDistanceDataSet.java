package chuggaChugga.model;

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


}
