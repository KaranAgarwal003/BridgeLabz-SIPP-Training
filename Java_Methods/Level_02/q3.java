import java.util.Arrays;

public class q3 {

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

    // Method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    // Method to find sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        return Arrays.stream(digits)
                .map(d -> (int) Math.pow(d, 2))
                .sum();
    }

    // Method to check if number is Harshad number
    public static boolean isHarshadNumber(int number) {
        int[] digits = getDigitsArray(number);
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10]; // 0-9
        for (int digit : digits) {
            freq[digit]++;
        }

        int[][] result = Arrays.stream(freq)
                .boxed()
                .filter(f -> f > 0)
                .map(f -> new int[2])
                .toArray(int[][]::new);

        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    // Main method to demonstrate
    public static void main(String[] args) {
        int number = 1223;

        System.out.println("Number: " + number);

        int digitCount = countDigits(number);
        System.out.println("Digit Count: " + digitCount);

        int[] digits = getDigitsArray(number);
        System.out.println("Digits Array: " + Arrays.toString(digits));

        int digitSum = sumOfDigits(digits);
        System.out.println("Sum of Digits: " + digitSum);

        int squareSum = sumOfSquares(digits);
        System.out.println("Sum of Squares of Digits: " + squareSum);

        System.out.println("Is Harshad Number: " + isHarshadNumber(number));

        System.out.println("Digit Frequencies:");
        int[][] frequencies = digitFrequency(digits);
        for (int[] row : frequencies) {
            System.out.println("Digit " + row[0] + ": " + row[1] + " time(s)");
        }
    }
}
