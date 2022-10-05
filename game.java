import java.util.*;
import java.io.*;
import java.awt.*;

public class game {
    public static void main(String[] args){
        InputReader sc = new InputReader(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            String s = sc.next();
            int zero=0,one=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1')one++;
                else zero++;
            }
            if(Math.min(zero,one)%2==0)sb.append("NET\n");
            else sb.append("DA\n");
        }
        System.out.println(sb);
    }
}
