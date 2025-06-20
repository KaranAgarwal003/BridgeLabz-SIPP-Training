import java.util.*;
public class fibonacciSequence{
    public static void fibonacci(int n){
        if(n==1){
            System.out.print("0 ");
        }
        if(n==2){
            System.out.print("0 1 ");
        }
        else if(n>2){
            int a=0;int b=1;
            System.out.print(a+" "+b+" ");
            for(int i=3;i<=n;i++){
                int c=a+b;
                System.out.print(c+" ");
                a=b;
                b=c;    
        }
    }
}
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the number of terms in the Fibonacci sequence: ");
      int n = sc.nextInt();
      fibonacci(n);  
    }
}
