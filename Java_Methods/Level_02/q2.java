import java.util.Arrays;

public class q2 {

    // Method to count digits
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // Method to get digits array
    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    // Method to check duck number
    public static boolean isDuckNumber(int number) {
        String numStr = String.valueOf(number);
        return numStr.indexOf('0') > 0;
    }

    // Method to check armstrong number
    public static boolean isArmstrong(int number) {
        int[] digits = getDigitsArray(number);
        int power = digits.length;
        int sum = Arrays.stream(digits).map(d -> (int) Math.pow(d, power)).sum();
        return sum == number;
    }

    // Method to find largest and second largest
    public static int[] findLargestTwo(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                second = largest;
                largest = digit;
            } else if (digit > second && digit != largest) {
                second = digit;
            }
        }
        return new int[]{largest, second};
    }

    // Method to find smallest and second smallest
    public static int[] findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                second = smallest;
                smallest = digit;
            } else if (digit < second && digit != smallest) {
                second = digit;
            }
        }
        return new int[]{smallest, second};
    }

    // Main method to demonstrate
    public static void main(String[] args) {
        int number = 153;

        System.out.println("Number: " + number);

        int count = countDigits(number);
        System.out.println("Digit Count: " + count);

        int[] digits = getDigitsArray(number);
        System.out.println("Digits Array: " + Arrays.toString(digits));

        System.out.println("Is Duck Number: " + isDuckNumber(number));
        System.out.println("Is Armstrong Number: " + isArmstrong(number));

        int[] largestTwo = findLargestTwo(digits);
        System.out.println("Largest: " + largestTwo[0] + ", Second Largest: " + largestTwo[1]);

        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Smallest: " + smallestTwo[0] + ", Second Smallest: " + smallestTwo[1]);
    }
}
