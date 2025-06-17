
public class q11 {

    public double[] calculateTrigonometricFunctions(double angle) {
        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Return results as an array
        return new double[] { sine, cosine, tangent };
    }

    public static void main(String[] args) {
        q11 calc = new q11();
        double angle = 45.0; // you can change this to any angle

        double[] results = calc.calculateTrigonometricFunctions(angle);

        // Print results up to 2 decimal places
        System.out.printf("Sine(%.2f°) = %.2f%n", angle, results[0]);
        System.out.printf("Cosine(%.2f°) = %.2f%n", angle, results[1]);
        System.out.printf("Tangent(%.2f°) = %.2f%n", angle, results[2]);
    }
}
