package WorkShop.VehicleRentalApplication;

public class Bike extends Vehicle implements Rentable {
    private int scharge = 100;

    public Bike(int days) {
        super(days, "Bike", 100); // base rate for bikes
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days + scharge;
    }
}
