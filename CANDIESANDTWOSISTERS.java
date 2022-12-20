import java.util.*;
public class CANDIESANDTWOSISTERS{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int m=0;m<t;m++){
            long n=sc.nextInt();
            if(n>2){
                long ans=n/2;
                if(n%2==0){
                    ans-=1;
                }
                System.out.println(ans);
            }
            else{
                  System.out.println(0);
            }
        }
    }
}