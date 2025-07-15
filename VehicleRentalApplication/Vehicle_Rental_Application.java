// qn

// Build a system for renting bikes, cars, and trucks to customers.

// Concepts Used:
// ● Class: Vehicle, Bike, Car, Truck, Customer (Scenario-based problems)
// ● Constructors: Custom constructors for different vehicle types
// ● Access Modifiers: protected for vehicle attributes to allow subclass access
// ● Interface: Rentable with method calculateRent(int days)
// ● Operators: Used in rent calculation (e.g., baseRate × days ± surcharges)

// OOP Concepts:
// ○ Abstraction: Rentable abstracts rental behavior
// ○ Inheritance: Car, Bike, Truck inherit from Vehicle
// ○ Polymorphism: Rent calculation differs by vehicle type
// ○ Encapsulation: All fields hidden behind getters/setters
package WorkShop.VehicleRentalApplication;

import java.util.*;
public class Vehicle_Rental_Application {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Rental Application!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of days you want to rent the vehicle:");
        
        // Print statement to confirm input is being taken
        int days = sc.nextInt();
        System.out.println("You want to rent for " + days + " days.");  // confirm the value

        System.out.println("Available vehicles for rent:");
        System.out.println("1. Bike");
        System.out.println("2. Car");
        System.out.println("3. Truck");
        System.out.println("Please select a vehicle to rent");

        int n = sc.nextInt();
        switch(n){
            case 1:
                System.out.println("You selected Bike.");
                Rentable bike = new Bike(days);
                System.out.println("Bike rental cost for " + days + " days: " + bike.calculateRent(days));
                break;
            case 2:
                System.out.println("You selected Car.");
                Rentable car = new Car(days);
                System.out.println("Car rental cost for " + days + " days: " + car.calculateRent(days));
                break;
            case 3:
                System.out.println("You selected Truck.");
                Rentable truck = new Truck(days);
                System.out.println("Truck rental cost for " + days + " days: " + truck.calculateRent(days));
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
        System.out.println("Do You Want To Confirm Your Booking? (yes/no)");
        String confirm = sc.next();
        if(confirm.equalsIgnoreCase("yes")){
            System.out.println("Your booking has been confirmed!");
        } else {
            System.out.println("Your booking has been cancelled.");
        }

        System.out.println("Thank you for using the Vehicle Rental Application!");    
    }
}
