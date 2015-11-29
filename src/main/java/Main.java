package main.java;


import main.java.services.RouteService;

public class Main {
    public static void main(String[] args){
        System.out.println(RouteService.getRouteById(1));
        System.out.println(RouteService.getRouteById(2));

    }
}
