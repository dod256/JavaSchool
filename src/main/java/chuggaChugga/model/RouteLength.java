package chuggaChugga.model;

import javax.persistence.*;

/*
* Represent RouteLength table from the DB
* */
@Entity
@Table(name = "RouteLength")
public class RouteLength {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int routeLength;

    public RouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public RouteLength() {
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
