
import java.util.LinkedList;
import java.util.Queue;

class Customer {

    String name;
    boolean isEmergency;

    public Customer(String name, boolean isEmergency) {
        this.name = name;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        return name + (isEmergency ? " (Emergency)" : " (Normal)");
    }
}

class CallCenterQueue {

    private Queue<Customer> emergencyQueue = new LinkedList<>();
    private Queue<Customer> normalQueue = new LinkedList<>();

    // Add customer to the appropriate queue
    public void addCustomer(Customer customer) {
        if (customer.isEmergency) {
            emergencyQueue.offer(customer);
        } else {
            normalQueue.offer(customer);
        }
    }

    // Serve next customer (emergency first)
    public Customer serveNext() {
        if (!emergencyQueue.isEmpty()) {
            return emergencyQueue.poll();
        } else {
            return normalQueue.poll();
        }
    }

    // Display both queues
    public void displayQueues() {
        System.out.println("Emergency Queue: " + emergencyQueue);
        System.out.println("Normal Queue: " + normalQueue);
    }

    public static void main(String[] args) {
        CallCenterQueue callCenter = new CallCenterQueue();
        callCenter.addCustomer(new Customer("Alice", false));
        callCenter.addCustomer(new Customer("Bob", true));
        callCenter.addCustomer(new Customer("Charlie", false));
        callCenter.addCustomer(new Customer("Diana", true));

        callCenter.displayQueues();

        System.out.println("\nServing customers:");
        Customer served;
        while ((served = callCenter.serveNext()) != null) {
            System.out.println("Served: " + served);
        }
    }
}
