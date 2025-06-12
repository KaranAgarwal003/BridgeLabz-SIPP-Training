
import java.util.*;

public class KaranAgarwal_02 {

    public static void main(String[] args) {
        //1.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the birth year");
        int year = sc.nextInt();
        int age = 2024 - year;
        System.out.println("Harry's age in 2024 is" + age);

        //2.
        int average = ((94 + 95 + 96) / 3);
        System.out.println("Sam’s average mark in PCM is" + average);

        //3.
        double km = 10.8;
        double miles = km / 1.6;
        System.out.println("The distance 10.8 km in miles is" + miles);
    }
}
