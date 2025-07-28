
import java.util.*;

// Reservation class
class Reservation {

    private String customerName;
    private int tableNumber;
    private String reservationTime;

    public Reservation(String customerName, int tableNumber, String reservationTime) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    // Prevent duplicate reservation for same table/time
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation r = (Reservation) o;
        return tableNumber == r.tableNumber
                && reservationTime.equals(r.reservationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, reservationTime);
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " reserved by " + customerName + " at " + reservationTime;
    }
}

// Generic ReservationSystem for any branch/outlet
class ReservationSystem<T extends Reservation> {

    private Set<T> reservations = new LinkedHashSet<>(); // maintains insertion order

    // Add reservation (prevent duplicate table/time)
    public boolean addReservation(T reservation) {
        if (reservations.contains(reservation)) {
            System.out.println("Duplicate reservation for table " + reservation.getTableNumber()
                    + " at " + reservation.getReservationTime());
            return false;
        }
        reservations.add(reservation);
        return true;
    }

    // View upcoming reservations in order
    public void viewUpcomingReservations() {
        System.out.println("Upcoming Reservations:");
        for (T r : reservations) {
            System.out.println(r);
        }
    }
}

public class RestaurantReservationDemo {

    public static void main(String[] args) {
        ReservationSystem<Reservation> branchA = new ReservationSystem<>();

        branchA.addReservation(new Reservation("Alice", 1, "7:00 PM"));
        branchA.addReservation(new Reservation("Bob", 2, "7:30 PM"));
        branchA.addReservation(new Reservation("Charlie", 1, "8:00 PM"));
        branchA.addReservation(new Reservation("Diana", 1, "7:00 PM"));

        branchA.viewUpcomingReservations();
    }
}
