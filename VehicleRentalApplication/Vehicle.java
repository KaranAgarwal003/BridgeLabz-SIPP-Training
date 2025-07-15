package WorkShop.VehicleRentalApplication;

public abstract class Vehicle {
    protected int days;
    protected String vehicleType;
    protected double baseRate;

    public Vehicle(int days, String vehicleType, double baseRate) {
        this.days = days;
        this.vehicleType = vehicleType;
        this.baseRate = baseRate;
    }

    public int getDays() {
        return days;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getBaseRate() {
        return baseRate;
    }
}
