import java.util.Scanner;

public class q12 {

    // Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate slope and intercept, returns array [slope, intercept]
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance between the points: %.2f\n", distance);

        // Line Equation
        if (x1 == x2) {
            System.out.println("The line is vertical. Equation: x = " + x1);
        } else {
            double[] lineParams = calculateLineEquation(x1, y1, x2, y2);
            double slope = lineParams[0];
            double intercept = lineParams[1];
            System.out.printf("Equation of the line: y = %.2fx + %.2f\n", slope, intercept);
        }

        sc.close();
    }
}
