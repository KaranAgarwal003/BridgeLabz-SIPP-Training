import java.util.*;
public class KaranAgarwal_02_level1{
    public static void main(String[] args) {    
        Scanner sc=new Scanner(System.in);
        //1.
        int n=sc.nextInt();
        if(n%5==0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        //2.
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        if(x<y && x<z){
            System.out.println("first number is the smallest");
        }

        //3.
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=sc.nextInt();
        if(p>q && p>r){
            System.out.println("first number is the largest");
        } else if(q>p && q>r){
            System.out.println("second number is the largest");
        } else {
            System.out.println("third number is the largest");
        }

        //4.
        int a=sc.nextInt();
        if(a>=0){
            System.out.println("given number is natural");
            System.out.println("Sum of natural numbers is: " + (a * (a + 1)) / 2);
        }

        //5.
        int age=sc.nextInt();
        if(age>=18){
            System.out.println("Eligible for voting");
        } else {
            System.out.println("Not eligible for voting");
        }

        //6.
        int num=sc.nextInt();
        if(num==0){
            System.out.println("Number is zero");
        } else if(num>0){
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }

        //7.
        int date=sc.nextInt();
        String month=sc.next();
        if(((month=="march" && date>=20) ||month=="april"||month=="may"||(month=="june" && date<=20))){
            System.out.println("it is a spring season");
        }

        //8.
        int val=sc.nextInt();
        int count=1;
        while(val>=count){
            System.out.println(val);
            val--;
        }



    }    
}