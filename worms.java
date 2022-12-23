import java.io.*;
import java.util.*;
import java.math.*;
public class worms {
    public static void main(String[] args) throws IOException{
        PrintWriter out=new PrintWriter(System.out);
        FastReader input=new FastReader(); 
        long sum=0;
        int n=input.nextInt();
        long[] arr=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
            sum+=arr[i];
            arr[i]=sum;
        }int m=input.nextInt();
        long[] q=new long[m];
        for (int i = 0; i < m; i++) {
            q[i]=input.nextLong();
        }
        for (int i = 0; i < m; i++) {
            out.println(bs(arr,0,n-1,q[i]));
        }
        
        
        
        
        out.flush();
    }
    public static int bs(long[] arr,int start,int end,long x){
        while (start<end) {
            int mid=start+(end-start)/2;
            if(arr[mid]<x){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start+1;
    }
    
    
    
    
    
    
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}