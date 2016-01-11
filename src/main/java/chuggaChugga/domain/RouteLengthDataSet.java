package chuggaChugga.domain;

import javax.persistence.*;

/*
* Represent RouteLength table from the DB
* */
@Entity
@Table(name = "RouteLength")
public class RouteLengthDataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int routeLength;

    public RouteLengthDataSet(int routeLength) {
        this.routeLength = routeLength;
    }

    public RouteLengthDataSet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }
}
