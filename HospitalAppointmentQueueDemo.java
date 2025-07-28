
import java.util.*;

// Base Appointment class
class Appointment {

    private String patientName;
    private String doctorName;
    private String timeSlot;

    public Appointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + timeSlot;
    }
}

// Generic queue manager for appointments or other queue types
class QueueManager<T> {

    private Queue<T> queue = new LinkedList<>();

    // Add to queue
    public void add(T item) {
        queue.offer(item);
    }

    // Serve next (FIFO)
    public T serveNext() {
        return queue.poll();
    }

    // View next without removing
    public T peekNext() {
        return queue.peek();
    }

    // Display all in queue
    public void displayQueue() {
        System.out.println("Current queue:");
        for (T item : queue) {
            System.out.println(item);
        }
    }
}

public class HospitalAppointmentQueueDemo {

    public static void main(String[] args) {
        QueueManager<Appointment> appointmentQueue = new QueueManager<>();

        appointmentQueue.add(new Appointment("Alice", "Dr. Smith", "10:00 AM"));
        appointmentQueue.add(new Appointment("Bob", "Dr. Smith", "10:30 AM"));
        appointmentQueue.add(new Appointment("Charlie", "Dr. Lee", "11:00 AM"));

        appointmentQueue.displayQueue();

        System.out.println("\nNext appointment:");
        System.out.println(appointmentQueue.peekNext());

        System.out.println("\nServing appointments:");
        while (appointmentQueue.peekNext() != null) {
            System.out.println("Served: " + appointmentQueue.serveNext());
        }
    }
}
