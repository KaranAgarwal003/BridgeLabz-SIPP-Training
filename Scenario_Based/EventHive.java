
interface EventManager {
    void addEvent(Event event);
    void removeEvent(int eventId);
    void modifyEvent(int eventId, String newName, String newDate);
}

class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // Register for event and get a ticket
    public Ticket register(Event event) {
        return new Ticket(this, event);
    }
}

class Event {
    int eventId;
    String eventName;
    String eventDate;

    public Event(int eventId, String eventName, String eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }
}

class Ticket {
    User user;
    Event event;

    public Ticket(User user, Event event) {
        this.user = user;
        this.event = event;
        System.out.println("Ticket created for " + user.name + " to event " + event.eventName);
    }
}

class Admin implements EventManager {
    private java.util.Map<Integer, Event> events = new java.util.HashMap<>();

    public void addEvent(Event event) {
        events.put(event.eventId, event);
        System.out.println("Event added: " + event.eventName);
    }

    public void removeEvent(int eventId) {
        if (events.remove(eventId) != null) {
            System.out.println("Event removed: " + eventId);
        } else {
            System.out.println("Event not found: " + eventId);
        }
    }

    public void modifyEvent(int eventId, String newName, String newDate) {
        Event event = events.get(eventId);
        if (event != null) {
            event.eventName = newName;
            event.eventDate = newDate;
            System.out.println("Event modified: " + eventId);
        } else {
            System.out.println("Event not found: " + eventId);
        }
    }

    public void displayEvents() {
        for (Event e : events.values()) {
            System.out.println(e.eventId + ": " + e.eventName + " on " + e.eventDate);
        }
    }
}

public class EventHive {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Event event1 = new Event(1, "TechTalk", "2025-08-01");
        Event event2 = new Event(2, "CodeFest", "2025-08-15");

        admin.addEvent(event1);
        admin.addEvent(event2);
        admin.displayEvents();

        User user = new User(101, "Alice");
        Ticket ticket = user.register(event1);

        admin.modifyEvent(2, "CodeFest 2.0", "2025-08-16");
    }
}
