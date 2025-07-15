package WorkShop.VehicleRentalApplication;


public class Car extends Vehicle implements Rentable {
    private int scharge = 500;

    public Car(int days) {
        super(days, "Car", 200); // base rate for cars
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days + scharge;
    }
}
