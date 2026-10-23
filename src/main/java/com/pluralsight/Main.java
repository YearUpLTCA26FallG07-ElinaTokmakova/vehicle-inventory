package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];

        //adding Vehicle objects to array
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        //select command menu
        int command = showMenu(scanner);

        while(command != 6) {
            switch (command) {
                case 1 -> listAll(vehicles);
                case 2 -> searchMakeModel(vehicles);
                case 3 -> searchPrice(vehicles);
                case 4 -> searchColor(vehicles);
                case 5 -> addVehicle(vehicles);
                default -> System.out.println("Invalid command. Please enter an option between 1-6.");
            }
            command = showMenu(scanner);
        }

        System.out.println("Goodbye!");
    }

    public static int showMenu(Scanner scanner) {

        System.out.print("\nWhat do you want to do?" +
                "\n1 - List all vehicles" +
                "\n2 - Search by make/model" +
                "\n3 - Search by price range" +
                "\n4 - Search by color" +
                "\n5 - Add a vehicle" +
                "\n6 - Quit" +
                "\n\nEnter your command: ");
        int command = scanner.nextInt();
        scanner.nextLine();

        return command;
    }

    public static void listAll(Vehicle[] vehicles) {
        System.out.println(); //blank line
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                vehicle.display();
            }
        }
    }

    public static void searchMakeModel(Vehicle[] vehicles) {
        System.out.print("Search make/model by keyword: ");
        String target = scanner.nextLine();

        //scan left to right until target appears
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getMakeModel().toLowerCase().contains(target)) {
                vehicle.display();
            }
        }
    }

    public static void searchPrice(Vehicle[] vehicles) {
        System.out.print("Search by price: ");
        double target = scanner.nextDouble();

        //scan left to right until target appears
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getPrice() == target) {
                vehicle.display();
            }
        }
    }

    public static void searchColor(Vehicle[] vehicles) {
        System.out.print("Search color by keyword: ");
        String target = scanner.nextLine();

        //scan left to right until target appears
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getColor().toLowerCase().contains(target)) {
                vehicle.display();
            }
        }
    }

    private static void addVehicle(Vehicle[] vehicles) {
        System.out.println("\n=== New vehicle ===");
        System.out.print("Enter vehicle ID? ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = new Vehicle(vehicleId, makeModel, color, odometer, price);
                break;
            }
        }

        System.out.println("New vehicle was added.");
    }
}