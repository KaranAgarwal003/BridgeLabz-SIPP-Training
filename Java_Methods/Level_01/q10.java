import java.util.*;
public class q10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int temp=sc.nextInt();
        int speed=sc.nextInt();

        double windchill=35.74+0.6215*temp-35.75*Math.pow(speed, 0.16)+0.4275*temp*Math.pow(speed, 0.16);
        System.out.printf("The wind chill index is %.2f.%n", windchill);
    }
}