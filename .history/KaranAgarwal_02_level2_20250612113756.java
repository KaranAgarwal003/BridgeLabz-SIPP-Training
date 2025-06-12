import java.util.*;
public class KaranAgarwal_02_level2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //1.
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + "," + subtraction + "," + multiplication + " and " + division);

        //2.
        int base = sc.nextInt();
        int height1 = sc.nextInt();
        double area = 0.5 * base * height1;
        System.out.println("The area of the triangle with base " + base + " and height " + height1 + " is " + area);

        //3.
        int side = sc.nextInt();
        int perimeter = 4 * side;
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        //4.
        int feet = sc.nextInt();
        double yard = feet / 3.0;
        double miles2 = yard / 1760.0;
        System.out.println("The distance in feet is " + feet + ", which is equal to " + yard + " yards and " + miles2 + " miles.");

        //5.
        int unit = sc.nextInt();
        int price = sc.nextInt();
        int totalPrice = unit * price;
        System.out.println("The total price for " + unit + " units at a price of " + price + " per unit is " + totalPrice + ".");

        //6.
        int num1=sc
        
    }
}