package com.example.garage;

import java.util.ArrayList;

public class Garage {

//     * "Cars":["Kia Picanto","Hyundai i30","Mercedes E"]  --> Cars string array
// * ,"open":true --> Boolean openStatus
// * ,"address":"Hamasger 45/15" --> String address
// * ,"name":"Millennium Leasing" --> String storeName
// * }

    private ArrayList<String> cars;
    private Boolean openStatus;
    private String address;
    private String name;

    public Garage() {
    }

    public ArrayList<String> getCars() {
        return cars;
    }

    public Garage setCars(ArrayList<String> cars) {
        this.cars = cars;
        return this;
    }

    public Boolean getOpenStatus() {
        return openStatus;
    }

    public Garage setOpenStatus(Boolean openStatus) {
        this.openStatus = openStatus;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Garage setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public Garage setName(String name) {
        this.name = name;
        return this;
    }
}
