import java.util.*;

public class coffee_Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        double price = 0, total = 0;
        boolean running = true;

        System.out.println("Welcome to the Coffee Shop!");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Espresso    - ₹80");
            System.out.println("2. Cappuccino  - ₹100");
            System.out.println("3. Latte       - ₹120");
            System.out.println("4. Cold Coffee - ₹110");
            System.out.println("5. Exit & Bill");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    price = 80;
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    total += price * quantity;
                    System.out.println("Espresso added to bill.");
                    break;

                case 2:
                    price = 100;
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    total += price * quantity;
                    System.out.println("Cappuccino added to bill.");
                    break;

                case 3:
                    price = 120;
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    total += price * quantity;
                    System.out.println("Latte added to bill.");
                    break;

                case 4:
                    price = 110;
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    total += price * quantity;
                    System.out.println("Cold Coffee added to bill.");
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("\n🧾 Your Total Bill: ₹" + total);
        System.out.println("Thank you! Visit again ☕");

        sc.close();
    }
}
