
import java.time.LocalDate;

class Member {

    private String name;
    private String id;
    private LocalDate membershipDate;
    private int validityInDays; // e.g., 365 for 1 year

    public Member(String name, String id, LocalDate membershipDate, int validityInDays) {
        this.name = name;
        this.id = id;
        this.membershipDate = membershipDate;
        this.validityInDays = validityInDays;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    // Check if membership is still valid
    public boolean isMembershipValid() {
        LocalDate expiryDate = membershipDate.plusDays(validityInDays);
        return !LocalDate.now().isAfter(expiryDate);
    }

    public LocalDate getExpiryDate() {
        return membershipDate.plusDays(validityInDays);
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + id + "), Joined: " + membershipDate
                + ", Expires: " + getExpiryDate()
                + ", Valid: " + (isMembershipValid() ? "Yes" : "No");
    }
}

public class LibraryMembershipTracker {

    public static void main(String[] args) {
        Member m1 = new Member("Alice", "M1001", LocalDate.now().minusDays(100), 365);
        Member m2 = new Member("Bob", "M1002", LocalDate.now().minusDays(400), 365);

        System.out.println(m1);
        System.out.println(m2);

        System.out.println("Is Alice's membership valid? " + m1.isMembershipValid());
        System.out.println("Is Bob's membership valid? " + m2.isMembershipValid());
    }
}
