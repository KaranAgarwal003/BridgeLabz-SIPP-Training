
interface SensorReadable {

    void readSensorData();
}

abstract class IrrigationUnit implements SensorReadable {

    private double calibrationValue;

    public IrrigationUnit(double calibrationValue) {
        this.calibrationValue = calibrationValue;
    }

    // Protected method to allow subclasses to use calibration
    protected double getCalibrationValue() {
        return calibrationValue;
    }

    // Prevent external modification
    private void calibrate(double value) {
        calibrationValue = value;
    }

    // Abstract watering method
    public abstract void startWatering();

    // Default sensor reading
    public void readSensorData() {
        System.out.println("Reading generic sensor data...");
    }
}

class Sprinkler extends IrrigationUnit {

    public Sprinkler(double calibrationValue) {
        super(calibrationValue); // Constructor chaining
    }

    @Override
    public void startWatering() {
        System.out.println("Sprinkler watering with calibration: " + getCalibrationValue());
    }

    @Override
    public void readSensorData() {
        System.out.println("Sprinkler reading soil moisture sensor...");
    }
}

class DripSystem extends IrrigationUnit {

    public DripSystem(double calibrationValue) {
        super(calibrationValue); // Constructor chaining
    }

    @Override
    public void startWatering() {
        System.out.println("DripSystem watering with calibration: " + getCalibrationValue());
    }

    @Override
    public void readSensorData() {
        System.out.println("DripSystem reading humidity sensor...");
    }
}

public class AgraBot {

    public static void main(String[] args) {
        IrrigationUnit sprinkler = new Sprinkler(1.5);
        IrrigationUnit drip = new DripSystem(2.0);

        sprinkler.readSensorData();
        sprinkler.startWatering();

        drip.readSensorData();
        drip.startWatering();
    }
}
