import java.util.*;
public class ticket_Booking_System {
        
    public static void bookTicket() {
        Scanner sc = new Scanner(System.in);

        int plat = 0, gold = 0, silver = 0;
        int pop_big = 0, pop_med = 0, pop_small = 0;
        int Cold_Drink = 0, burger = 0;

        System.out.println("Welcome to the Ticket Booking System");
        System.out.println("Would you like to book a ticket? (for yes enter 1 / for no enter 0 :)");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter number of platinum tickets you want (Price: 500 per seat):");
            plat = sc.nextInt();

            System.out.println("Enter number of gold tickets you want (Price: 300 per seat):");
            gold = sc.nextInt();

            System.out.println("Enter number of silver tickets you want (Price: 200 per seat):");
            silver = sc.nextInt();
        } else if (choice == 0) {
            System.out.println("Thank you for visiting. Have a great day!");
            return;
        } else {
            System.out.println("Invalid choice. Please enter 1 or 0.");
            return;
        }

        int plat_price = plat * 500;
        int gold_price = gold * 300;
        int silver_price = silver * 200;

        System.out.println("Would you like to buy snacks? (if yes press 1 / if no press 0)");
        int snack = sc.nextInt();

        if (snack == 1) {
            System.out.println("What would you like to buy?");
            System.out.println("1. Popcorn");
            System.out.println("2. Cold drink");
            System.out.println("3. Burger");

            int s = sc.nextInt();

            if (s == 1) {
                System.out.println("Enter the size:");
                System.out.println("1. Big");
                System.out.println("2. Medium");
                System.out.println("3. Small");
                int n = sc.nextInt();

                if (n == 1) {
                    System.out.println("Enter the number of big buckets:");
                    int big = sc.nextInt();
                    pop_big = big * 500;
                } else if (n == 2) {
                    System.out.println("Enter the number of medium buckets:");
                    int med = sc.nextInt();
                    pop_med = med * 300;
                } else if (n == 3) {
                    System.out.println("Enter the number of small buckets:");
                    int small = sc.nextInt();
                    pop_small = small * 150;
                }

            } else if (s == 2) {
                System.out.println("Choose your cold drink:");
                System.out.println("1. Pepsi");
                System.out.println("2. CocaCola");
                System.out.println("3. Mountain Dew");
                Cold_Drink = sc.nextInt();
            } else if (s == 3) {
                System.out.println("Enter the number of burgers you want (40 per piece):");
                burger = sc.nextInt();
            }
        }

        int tickets_total = plat_price + gold_price + silver_price;
        int pop_total = pop_big + pop_med + pop_small;
        int cold_total = Cold_Drink * 50;
        int burger_total = burger * 40;
        int total = tickets_total + pop_total + cold_total + burger_total;

        System.out.println("Summary of your purchase:");
        System.out.println("Total Ticket Cost: ₹" + tickets_total);
        System.out.println("Total Popcorn Cost: ₹" + pop_total);
        System.out.println("Total Cold Drink Cost: ₹" + cold_total);
        System.out.println("Total Burger Cost: ₹" + burger_total);
        System.out.println("Grand Total: ₹" + total);

        System.out.println("Thank you for booking. Enjoy your show!");
    }
    public static void main(String[] args) {
        bookTicket();
        System.out.println("Do you wish to book another ticket? (yes=1/no=0)");
        Scanner sc = new Scanner(System.in);
        int anotherBooking = sc.nextInt();
        while (anotherBooking == 1) {
            bookTicket();
            System.out.println("Do you wish to book another ticket? (yes=1/no=0)");
            anotherBooking = sc.nextInt();
        }
        System.out.println("Thank you for using the Ticket Booking System. Goodbye!");
    }
}
