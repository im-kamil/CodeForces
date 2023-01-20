import java.util.*;
public class cheapTravel{
    public static void main(String args[]){
    Scanner sc = new Scanner (System.in);
   int n=sc.nextInt();
    int m=sc.nextInt();
    int a=sc.nextInt();
    int b=sc.nextInt();
    int x=n*a;
    int rem=n%m;
    int y=n/m*b+rem*a;
    int z=n/m*b+b;
    System.out.println(Math.min(x,Math.min(y,z)));
    
    
    }
}