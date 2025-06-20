import java.util.*;

public class Number_Guessing_Game {

    public static int generateRandom(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 100 for the computer to guess: ");
        int userNumber = sc.nextInt();

        int low = 1;
        int high = 100;
        int guess;
        int attempts = 0;

        while (true) {
            guess = generateRandom(low, high);
            attempts++;

            if (guess == userNumber) {
                System.out.println("Computer guessed the number " + guess + " in " + attempts + " attempts!");
                break;
            } else if (guess < userNumber) {
                System.out.println("Computer guessed " + guess + " which is too low.");
                low = guess + 1;
            } else {
                System.out.println("Computer guessed " + guess + " which is too high.");
                high = guess - 1;
            }
        }
    }
}
