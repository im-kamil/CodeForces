import java.util.*;
import java.io.*;
import java.awt.*;
public class AgoodString {
    public static void main(String[] args){
        InputReader sc = new InputReader(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            System.out.println(solve(s,'a'));
        }
    }
    public static int solve(String s,char c){
        if(s.length()==1){
            if(s.charAt(0)==c)return 0;
            else return 1;
        }
        int one=0,two=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(s.charAt(i)==c)one++;
            }
            else{
                if(s.charAt(i)==c)two++;
            }
        }
        c++;
        int left=solve(s.substring(0,n/2),c);
        int right=solve(s.substring(n/2,n),c);

        return Math.min((n/2)-one+right,(n/2)-two+left);
    }
}
    
