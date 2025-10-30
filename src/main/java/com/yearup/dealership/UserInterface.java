package com.yearup.dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }
    public void display(){
        while(true){
            init();
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

            System.out.printf("\nWelcome to %s Dealership Manager\n", dealership.getName());
            System.out.println("What would you like to do today?");
            System.out.print("[1] Display All Vehicles\n");
            System.out.print("[2] Filter View\n");
            System.out.print("[3] Edit Vehicle Inventory\n");
            System.out.print("[4] Exit Dealership Manager\n");
            System.out.print("Type Here: ");
            //Get input
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    //display all
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    //filter search
                    filterMenu();
                    break;
                case 3:
                    //add/remove vehicle
                    editInventory();
                    break;
                case 4:
                    //exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input not recognized. Please try again!");
            }

            System.out.println("Press [ENTER] to continue.");
            String enter = scanner.nextLine();


    }
    public void filterMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\nFilter Search Menu");
            System.out.println("What would you like to search by?");
            System.out.println("[1] By Price Range");
            System.out.println("[2] By Make/Model");
            System.out.println("[3] By Year");
            System.out.println("[4] By Color");
            System.out.println("[5] By Mileage");
            System.out.println("[6] By Vehicle Type");
            System.out.println("[7] Exit Search");
            System.out.print("Type Here: ");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    keepGoing = false;
                    break;
            }
        }
    }
    public void editInventory(){
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\nEdit Inventory");
            System.out.println("[1] Add Vehicle");
            System.out.println("[2] Remove Vehicle");
            System.out.println("[3] Exit Edit Menu");
            System.out.print("Type Here: ");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    processAddVehicleRequest();
                    break;
                case 2:
                    processRemoveVehicleRequest();
                    break;
                case 3:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Input not recognized. Please try again!");

            }
        }

    }
    public void displayVehicles(ArrayList<Vehicle> list){
        for (Vehicle v : list) {
            if (!list.isEmpty()) {
                System.out.printf("%d|%d|%s|%s|%s|%s|%d|$%.2f\n", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        }
    }

    public void processGetByPriceRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Price:\nLowest Price: $");
        double lowestPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Highest Price: $");
        double highestPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.printf("\nListing All Vehicles Between $%.2f and $%.2f:\n",lowestPrice,highestPrice);
        if (!dealership.getVehiclesByPrice(lowestPrice,highestPrice).isEmpty()) {
            displayVehicles(dealership.getVehiclesByPrice(lowestPrice, highestPrice));
        }else{
            System.out.println("No Results found. Please try again.");
        }
        scanner.close();
    }
    public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Make/Model:\nMake: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.printf("\nListing All %s %s:\n",make,model);
        if (!dealership.getVehiclesByMakeModel(make,model).isEmpty()) {
            displayVehicles(dealership.getVehiclesByMakeModel(make, model));
        }else{
            System.out.println("No Results found. Please try again.");
        }

    }
    public void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Year:\nStarting Year: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ending Year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nListing All Vehicles Between %d and %d:\n",min,max);
        if (!dealership.getVehiclesByYear(min,max).isEmpty()) {
            displayVehicles(dealership.getVehiclesByYear(min,max));
        }else{
            System.out.println("No Results found. Please try again.");
        }

    }
    public void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Vehicle Color:\nColor: ");
        String color = scanner.nextLine();

        System.out.printf("\nListing All %s Vehicles:\n",color);
        if (!dealership.getVehiclesByColor(color).isEmpty()) {
            displayVehicles(dealership.getVehiclesByColor(color));
        }else{
            System.out.println("No Results found. Please try again.");
        }

    }
    public void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Mileage:\nLowest Mileage: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Highest Mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nListing All Vehicles With Mileage Between %d and %d:\n",min,max);
        if (!dealership.getVehiclesByMileage(min,max).isEmpty()) {
            displayVehicles(dealership.getVehiclesByMileage(min,max));
        }else{
            System.out.println("No Results found. Please try again.");
        }

    }

    public void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filter Search by Vehicle Type:\nType: ");
        String vehicleType = scanner.nextLine();

        System.out.printf("\nListing All %s Vehicles:\n",vehicleType);
        if (!dealership.getVehiclesByType(vehicleType).isEmpty()) {
            displayVehicles(dealership.getVehiclesByType(vehicleType));
        }else{
            System.out.println("No Results found. Please try again.");
        }

    }
    public void processGetAllVehiclesRequest(){
        System.out.println("Listing All Vehicles:");
        System.out.printf("%s|%s|%s\n",dealership.getName(),dealership.getAddress(),dealership.getAddress());
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
        DealershipFileManager fileManager = new DealershipFileManager();

        System.out.println("Add a Vehicle to Inventory");
        System.out.println("Please input vehicle details.");

        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Mileage: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(this.dealership);
        System.out.println("Vehicle added to inventory.");

    }
    public void processRemoveVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
        DealershipFileManager fileManager = new DealershipFileManager();

        System.out.println("Remove a Vehicle from Inventory");
        System.out.println("Please input vehicle details.");

        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Mileage: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
        dealership.removeVehicle(vehicle);

        fileManager.saveDealership(this.dealership);
        System.out.println("Vehicle removed from inventory.");
    }
}
