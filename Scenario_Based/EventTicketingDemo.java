
import java.util.*;

class Attendee {

    String name;
    int age;
    String email;

    // Constructor without email
    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = null;
    }

    // Constructor with email
    public Attendee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + age + (email != null ? ", " + email : "") + ")";
    }
}

class EventTicketingSystem {

    // event name -> booking queue
    private Map<String, Queue<Attendee>> eventQueues = new HashMap<>();

    // Add attendee to event queue
    public void bookTicket(String eventName, Attendee attendee) {
        eventQueues.putIfAbsent(eventName, new LinkedList<>());
        eventQueues.get(eventName).offer(attendee);
        System.out.println("Booked: " + attendee + " for " + eventName);
    }

    // Get position of attendee in queue (linear search)
    public int getPosition(String eventName, String attendeeName) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue == null) {
            return -1;
        }
        int pos = 1;
        for (Attendee a : queue) {
            if (a.name.equalsIgnoreCase(attendeeName)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    // Display queue for an event
    public void displayQueue(String eventName) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue == null || queue.isEmpty()) {
            System.out.println("No bookings for " + eventName);
            return;
        }
        System.out.println("Queue for " + eventName + ":");
        for (Attendee a : queue) {
            System.out.println(a);
        }
    }
}

public class EventTicketingDemo {

    public static void main(String[] args) {
        EventTicketingSystem ets = new EventTicketingSystem();

        ets.bookTicket("Rock Concert", new Attendee("Alice", 25));
        ets.bookTicket("Rock Concert", new Attendee("Bob", 30, "bob@email.com"));
        ets.bookTicket("Rock Concert", new Attendee("Charlie", 22));
        ets.bookTicket("Drama Play", new Attendee("Diana", 28, "diana@email.com"));

        ets.displayQueue("Rock Concert");
        ets.displayQueue("Drama Play");

        System.out.println("\nPosition of Bob in Rock Concert queue: "
                + ets.getPosition("Rock Concert", "Bob"));
        System.out.println("Position of Diana in Drama Play queue: "
                + ets.getPosition("Drama Play", "Diana"));
        System.out.println("Position of Eve in Rock Concert queue: "
                + ets.getPosition("Rock Concert", "Eve")); // This line was incomplete
    }
}
