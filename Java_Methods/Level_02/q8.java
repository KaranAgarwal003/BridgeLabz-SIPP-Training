import java.util.Arrays;

public class q8 {

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOtp() {
        return (int)(100000 + Math.random() * 900000); // range: 100000 to 999999
    }

    // Method to check if all OTPs in the array are unique
    public static boolean areOtpsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Duplicate found
                }
            }
        }
        return true; // All unique
    }

    // Main method
    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOtp();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));
        boolean unique = areOtpsUnique(otpArray);
        System.out.println("Are all OTPs unique? " + unique);
    }
}
