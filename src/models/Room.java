package models;

import services.Service;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, float usableArea, float rentalCost, int maximumNumberPeople, String rentalType, String freeService) {
        super(serviceName, usableArea, rentalCost, maximumNumberPeople, rentalType);
        this.freeService = freeService;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
