import java.util.*;
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalhandshakes = n * (n - 1) / 2;
        System.out.println("The total number of handshakes possible among " + n + " student is " + totalhandshakes + ".");
        
    }
}