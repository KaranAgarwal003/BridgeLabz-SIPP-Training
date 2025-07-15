package WorkShop.VehicleRentalApplication;

public class Truck extends Vehicle implements Rentable {
    private int scharge = 1000;

    public Truck(int days) {
        super(days, "Truck", 300); // base rate for trucks
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days + scharge;
    }
}
