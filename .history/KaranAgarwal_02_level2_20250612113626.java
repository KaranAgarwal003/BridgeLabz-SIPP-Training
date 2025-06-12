import java.util.*;
public class KaranAgarwal_02_level2{
    public static void main(String[] args) {
        Scanner sc=new 
        Scanner(System.in);
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + "," + subtraction + "," + multiplication + " and " + division);

        //12.
        int base = sc.nextInt();
        int height1 = sc.nextInt();
        double area = 0.5 * base * height1;
        System.out.println("The area of the triangle with base " + base + " and height " + height1 + " is " + area);

        //13.
        int side = sc.nextInt();
        int perimeter = 4 * side;
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        //14.
        int feet = sc.nextInt();
        double yard = feet / 3.0;
        double miles2 = yard / 1760.0;
        System.out.println("The distance in feet is " + feet + ", which is equal to " + yard + " yards and " + miles2 + " miles.");

        //15.
        int unit = sc.nextInt();
        int price = sc.nextInt();
        int totalPrice = unit * price;
        System.out.println("The total price for " + unit + " units at a price of " + price + " per unit is " + totalPrice + ".");

        //16.
        int n = sc.nextInt();
        int totalhandshakes = n * (n - 1) / 2;
        System.out.println("The total number of handshakes possible among " + n + " student is " + totalhandshakes + ".");

    }
}