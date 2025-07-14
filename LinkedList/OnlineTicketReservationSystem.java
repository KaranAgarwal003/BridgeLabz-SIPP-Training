
class TicketNode {

    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketCircularLinkedList {

    private TicketNode head;
    private TicketNode tail;

    // Add a new ticket at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            return;
        }
        if (head.ticketId == ticketId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        TicketNode temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        if (temp.next.ticketId == ticketId) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            tail.next = head;
        }
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer Name
    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No ticket found for customer: " + customerName);
        }
    }

    // Search by Movie Name
    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No ticket found for movie: " + movieName);
        }
    }

    // Calculate total number of booked tickets
    public int totalTickets() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    private void printTicket(TicketNode node) {
        System.out.println("TicketID: " + node.ticketId + ", Customer: " + node.customerName
                + ", Movie: " + node.movieName + ", Seat: " + node.seatNumber
                + ", Booking Time: " + node.bookingTime);
    }
}

public class OnlineTicketReservationSystem {

    public static void main(String[] args) {
        TicketCircularLinkedList tickets = new TicketCircularLinkedList();

        // Sample usage
        tickets.addTicket(1, "Alice", "Inception", "A1", "2025-07-14 18:00");
        tickets.addTicket(2, "Bob", "Interstellar", "B2", "2025-07-14 20:00");
        tickets.addTicket(3, "Charlie", "Inception", "A2", "2025-07-14 18:00");

        System.out.println("All tickets:");
        tickets.displayTickets();

        System.out.println("\nSearch by customer name 'Bob':");
        tickets.searchByCustomerName("Bob");

        System.out.println("\nSearch by movie name 'Inception':");
        tickets.searchByMovieName("Inception");

        System.out.println("\nTotal tickets booked: " + tickets.totalTickets());

        System.out.println("\nRemove ticket with ID 2:");
        tickets.removeTicket(2);
        tickets.displayTickets();
        System.out.println("Total tickets booked: " + tickets.totalTickets());
    }
}
