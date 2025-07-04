
import java.util.ArrayList;
import java.util.List;


abstract class Vehicle {

    protected String brand;
    protected String model;
    protected String fuelType;

    public Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public abstract double calculateServiceCost();

    public abstract void printServiceDetails();
}


class Car extends Vehicle {

    public Car(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 2000.0;
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Car Service Details:");
        System.out.println("Brand: " + brand + ", Model: " + model + ", Fuel: " + fuelType);
        System.out.println("Service Cost: " + calculateServiceCost());
    }
}


class Bike extends Vehicle {

    public Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 800.0; 
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Bike Service Details:");
        System.out.println("Brand: " + brand + ", Model: " + model + ", Fuel: " + fuelType);
        System.out.println("Service Cost: " + calculateServiceCost());
    }
}


class Truck extends Vehicle {

    public Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 5000.0; 
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Truck Service Details:");
        System.out.println("Brand: " + brand + ", Model: " + model + ", Fuel: " + fuelType);
        System.out.println("Service Cost: " + calculateServiceCost());
    }
}

public class VehicleManagementSystem {

    public static void main(String[] args) {
        List<Vehicle> garage = new ArrayList<>();
        garage.add(new Car("Toyota", "Camry", "Petrol"));
        garage.add(new Bike("Yamaha", "FZ", "Petrol"));
        garage.add(new Truck("Volvo", "FH16", "Diesel"));

        for (Vehicle v : garage) {
            v.printServiceDetails();
            System.out.println();
        }
    }
}
