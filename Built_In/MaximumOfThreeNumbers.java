
import java.util.Scanner;

public class MaximumOfThreeNumbers {

    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + max);
    }
}