import java.util.Scanner ;
import java.awt.*;
import java.util.*;

public class movebrackets {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        StringBuilder sc = new StringBuilder();
        int t = s.nextInt();
        while(t-->0){
            int  n=s.nextInt();
            char[] c=s.next().toCharArray();
            int count=0;
            int move=0;
            for(int i=0;i<n;i++){
                if(c[i]=='(')count++;
                else{
                    if(count==0)move++;
                    else count--;
                }
            }
            sc.append(move+"\n");
        }
        System.out.println(s);
        }
    }

