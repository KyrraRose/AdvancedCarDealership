package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }
    public void display(){
        init();
        while(true){
            mainMenu();
        }

    }
    //helper init
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    //helper menu
    private void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nWelcome to %s's Dealership Manager",dealership.getName());
        System.out.println("What would you like to do today?");
        System.out.print("[1] Display All Vehicles\n");
        System.out.print("[2] Filter View\n");
        System.out.print("[3] Edit Vehicle Inventory\n");
        System.out.print("[4] Exit Dealership Manager\n");
        System.out.print("Type Here: ");
        //Get input
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        switch(userChoice){
            case 1:
                //display all
                processGetAllVehiclesRequest();
                break;
            case 2:
                //filter search
                System.out.println("working on this functionality");
                break;
            case 3:
                //add/remove vehicle
                System.out.println("still programming");
                break;
            case 4:
                //exit
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Input not recognized. Please try again!");
        }
        System.out.println("Press [ENTER] to continue.");
        scanner.nextLine();



    }
    public void displayVehicles(ArrayList<Vehicle> list){
        for (Vehicle v : list){
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",v.getVin(),v.getYear(),v.getMake(),v.getModel(),v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
        }
    }
    public void processGetByPriceRequest(){}
    public void processGetByMakeModelRequest(){}
    public void processGetByYearRequest(){}
    public void processGetByColorRequest(){}
    public void processGetByMileageRequest(){}
    public void processGetByVehicleTypeRequest(){}
    public void processGetAllVehiclesRequest(){
        System.out.println("Listing All Vehicles:");
        System.out.printf("%s|%s|%s\n",dealership.getName(),dealership.getAddress(),dealership.getAddress());
        displayVehicles(dealership.getAllVehicles());
    }
    public void processRemoveVehicleRequest(){}
}
