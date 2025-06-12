
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

        //4.
        int cp = 129;
        int sp = 191;
        int profit = sp - cp;
        double profitPercentage = ((double) profit / cp) * 100;
        System.out.println("The Cost Price is INR 129 and Selling Price is INR 191\n"
                + "The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");
        
        //5.
        int pens=14;
        int students=3;
        
    }
}
