class Vehicle{
    int maxspeed;
    String fueltype;

    void displayInfo(){
        System.out.println("Max Speed: " + maxspeed + " km/h");
        System.out.println("Fuel Type: " + fueltype);
    }
}
class car extends Vehicle{
    int seatcapacity;
    car(int maxspeed, String fueltype, int seatcapacity){
        this.maxspeed = maxspeed;
        this.fueltype = fueltype;
        this.seatcapacity = seatcapacity;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatcapacity);
        
    }
}
class Bike extends Vehicle{
    String type;
    Bike(int maxspeed, String fueltype, String type){
        this.maxspeed = maxspeed;
        this.fueltype = fueltype;
        this.type = type;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Bike Type: " + type);
    }
}
class Truck extends Vehicle{
    int loadcapacity;
    Truck(int maxspeed, String fueltype, int loadcapacity){
        this.maxspeed = maxspeed;
        this.fueltype = fueltype;
        this.loadcapacity = loadcapacity;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Load Capacity: " + loadcapacity + " tons");
    }
}
public class VehicleAndTransportSystem {
    public static void main(String[] args) {
        Vehicle myCar = new car(180, "Petrol", 5);
        System.out.println("Car Details:");
        myCar.displayInfo();
        System.out.println();
        
        Vehicle myBike = new Bike(150, "Petrol", "Sport");
        System.out.println("Bike Details:");
        myBike.displayInfo();
        System.out.println();

        Vehicle myTruck = new Truck(120, "Diesel", 10);
        System.out.println("Truck Details:");
        myTruck.displayInfo();
    }
}