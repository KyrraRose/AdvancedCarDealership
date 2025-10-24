package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name,address,phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    //getVehiclesByPrice(double min, double max)
    //getVehiclesByMakeModel(String make, String model)
    //getVehiclesByYear(int min, int max)
    //getVehiclesByColor(String color)
    //getVehiclesByMileage(int min, int max)
    //getVehiclesByType(String vehicleType)
    public ArrayList<Vehicle> getAllVehicles(){
        System.out.println("Listing All Vehicles:");
        System.out.printf("%s|%s|%s\n",this.name,this.address,this.phone);
        for (Vehicle v : inventory){
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",v.getVin(),v.getYear(),v.getMake(),v.getModel(),v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
        }
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    //removeVehicle(vehicle)
}
