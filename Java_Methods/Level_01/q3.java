import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the sides in meter");
        int s1=sc.nextInt();
        int s2=sc.nextInt();
        int s3=sc.nextInt();
        
        double p=s1+s2+s3;

        double rounds=5*1000/p;
        System.out.printf("%.2f%n",rounds);
    }
}