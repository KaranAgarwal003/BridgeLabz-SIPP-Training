
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
        int pensperstudent= pens / students;
        int remainingPens = pens % students;
        System.out.println(" The Pen Per Student is " + pensperstudent + "and the remaining pen not distributed is " + remainingPens);

        //6.
        int fees=125000;
        int discount=10;
        double discountedamount=fees*discount/100;
        double finalFees = fees - discountedamount;
        System.out.println("The discount amount is INR "+discountedamount +  "and final discounted fee is INR "+finalFees);

        //7.
        int radius=6378;
        double radiusmiles=radius/1.6;
        double volume=(4/3)*3.14*radius*radius*radius;
        double volumemiles=(4/3)*3.14*radiusmiles*radiusmiles*radiusmiles;
        System.out.println("The volume of earth in cubic kilometers is "+volume+ "and cubic miles is "+volumemiles);

        //8.
        double distance=sc.nextInt();
        double miles1=km/1.6;
        System.out.println("The total miles is "+miles1+"mile for the given "+distance+ "km");

        //9.
        int fee=sc.nextInt();
        int disc=sc.nextInt();
        double discountAmount = fee * disc / 100.0;
        double finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR "+ discountAmount+"and final discounted fee is INR "+finalFee);


        //10.
        double height() = sc.nextInt();
        double heightininches=height/2.54;
        double heightinfoot
    }
}
