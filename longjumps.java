import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.awt.*;

public class longjumps {
    static int i;
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            int max=0;
            for(int i=n-1;i>=0;i--) {
                int temp = i + a[i];
                if (temp < n) a[i] += a[temp];
                max = Math.max(max,a[i]);
            }
            System.out.println(max);
        }
    }
}