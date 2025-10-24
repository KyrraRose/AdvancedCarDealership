package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
public Dealership getDealership(){
    try {
        BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        String[] header =buffReader.readLine().split("\\|");

        Dealership dealership = new Dealership(header[0],header[1],header[2]);

        String input;
        while((input = buffReader.readLine()) != null){
            String[] list = input.split("\\|");
            Vehicle vehicle = new Vehicle(Integer.parseInt(list[0]),Integer.parseInt(list[1]),list[2],list[3],list[4],list[5],Integer.parseInt(list[6]),Double.parseDouble(list[7]));
            dealership.addVehicle(vehicle);
        }
        return dealership;
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    return null;
}
public void saveDealership(Dealership dealership){

}
}
