import java.util.*;
public class q7{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();

        if(n1>n2 && n1>n3){
            System.out.println("The largest number is " + n1 + ".");
        } else if(n2>n1 && n2>n3) {
            System.out.println("The largest number is " + n2 + ".");
        } else if(n3>n1 && n3>n2) {
            System.out.println("The largest number is " + n3 + ".");
        }

        if(n1<n2 && n2<n3){
            System.out.println("The smallest number is " + n1 + ".");
        } else if(n2<n1 && n2<n3) {
            System.out.println("The smallest number is " + n2 + ".");
        } else if(n3<n1 && n3<n2) {
            System.out.println("The smallest number is " + n3 + ".");
        } 
        
    }
}