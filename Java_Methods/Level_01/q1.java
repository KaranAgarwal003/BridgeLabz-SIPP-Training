import java.util.*;
public class q1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        //1.
        System.out.println("Enter the principle amount,Rate of Interest and Time respectively");
        int p=sc.nextInt();
        int r=sc.nextInt();
        int t=sc.nextInt();

        int total=(p*r*t)/100;
        System.out.println("The Simple Interest is "+total+" for Principal"+p+ "Rate of Interest "+r+" and Time "+t);
        
    }
}