import java.util.Scanner;

public class q10 {

    // Method 1: Using Slope formula
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // To avoid divide by zero, use cross multiplication:
        // (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 - x1)
        int slope1 = (y2 - y1) * (x3 - x2);
        int slope2 = (y3 - y2) * (x2 - x1);
        return slope1 == slope2;
    }

    // Method 2: Using Area of Triangle formula
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + 
                             x2 * (y3 - y1) + 
                             x3 * (y1 - y2));
        return area == 0.0;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coordinates of point A (x1 y1): ");
        int x1 = sc.nextInt(), y1 = sc.nextInt();

        System.out.print("Enter coordinates of point B (x2 y2): ");
        int x2 = sc.nextInt(), y2 = sc.nextInt();

        System.out.print("Enter coordinates of point C (x3 y3): ");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        System.out.println();

        boolean bySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean byArea  = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Using Slope Method: Points are " + (bySlope ? "Collinear" : "Not Collinear"));
        System.out.println("Using Area Method : Points are " + (byArea  ? "Collinear" : "Not Collinear"));

        sc.close();
    }
}
