import java.util.Arrays;

public class q7 {

    // Method to find factors and return them as array
    public static int[] getFactors(int number) {
        int count = 0;

        // First loop: count number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        // Second loop: store factors
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to find greatest factor
    public static int getGreatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int factor : factors) {
            if (factor > max) max = factor;
        }
        return max;
    }

    // Method to find sum of factors
    public static int getSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find product of factors
    public static long getProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find product of cubes of factors
    public static double getProductOfCubes(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    // Main method for testing
    public static void main(String[] args) {
        int number = 12;

        int[] factors = getFactors(number);
        System.out.println("Factors of " + number + ": " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + getGreatestFactor(factors));
        System.out.println("Sum of Factors: " + getSumOfFactors(factors));
        System.out.println("Product of Factors: " + getProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + getProductOfCubes(factors));
    }
}
