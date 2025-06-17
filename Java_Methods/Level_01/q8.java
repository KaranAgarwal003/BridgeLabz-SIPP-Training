import java.util.*;
public class q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2=sc.nextInt();

        int q= n1 / n2;
        int r= n1 % n2;
        System.out.println("The quotient is " + q + " and the remainder is " + r + ".");
    }
}