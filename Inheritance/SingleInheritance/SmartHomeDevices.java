class Device{
    int deviceId;
    String status;
    void displayInfo(){
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device{
    String temperatureSetting;
    Thermostat(int deviceId,String status,String temperatureSetting){
        this.deviceId=deviceId;
        this.status=status;
        this.temperatureSetting=temperatureSetting;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("temperatuyreSetting: " + temperatureSetting);
    }
}
public class SmartHomeDevices {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat(101, "On", "22°C");
        thermostat.displayInfo();
    }
}