import java.util.*;
public class Pallindrom{
    public static boolean pallidromChecker(String str){
        for(int i=0;i>str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(pallidromChecker(str));
    }
}