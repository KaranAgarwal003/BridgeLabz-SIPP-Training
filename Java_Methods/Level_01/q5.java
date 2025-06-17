import java.util.*;
public class q5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int date=sc.nextInt();
        String month=sc.next();

        if((month=="march" && date>=20) || (month=="april") || (month=="may") || (month=="june" && date<=20)){
            System.out.println("Spring");
        }
    }
}