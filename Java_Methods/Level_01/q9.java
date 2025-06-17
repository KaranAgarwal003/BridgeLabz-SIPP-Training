import java.util.*;
public class q9 {
    public static void main(String[] args) {
    Scanner  sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    
    int each=n/m;
    int remaining=n%m;
    System.out.println("Each person gets " + each + " and remaining is " + remaining + ".");
    }
}