import java.util.*;
public class q1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[11];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int tallest=0;
        int smallest=0;
        int mean=0;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>tallest){
                tallest=arr[i];
            }else if(arr[i]<smallest){
                smallest=arr[i];
            }

            
        }
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
        }
        mean=sum/arr.length;

        System.out.println("Tallest: " + tallest);
        System.out.println("Smallest: " + smallest);
        System.out.println("Mean: " + mean);
    
        
    }
}