

import java.io.*;
import java.math.*;
import java.util.*;
public class differentArrays {
    static final int INF = 0x3f3f3f3f;
    static final long LNF = 0x3f3f3f3f3f3f3f3fL;
static  int a[],n,dp[][],mod=998244353;
static long ans=0;

    public static void main(String[] args) throws IOException {
        initReader();
 n=nextInt();
a=new int[n];
for(int i=0;i<n;i++)a[i]=nextInt();
int N=300*300;
dp=new int[n-1][(N*2+1)];
dp[0][a[1]+N]=1;
for(int i=1;i<n-1;i++){
 for(int j=-N;j<=N;j++){
     if(dp[i-1][j+N]!=0){//pw.println((i-1)+" "+j);
         if(j==0){
             dp[i][a[i+1]+N]+=dp[i-1][j+N];
             if(dp[i][a[i+1]+N]>=mod)dp[i][a[i+1]+N]%=mod;
         }
         else {
             dp[i][a[i+1]+j+N]+=dp[i-1][j+N];dp[i][a[i+1]-j+N]+=dp[i-1][j+N];
             if(dp[i][a[i+1]+j+N]>=mod)dp[i][a[i+1]+j+N]%=mod;
             if(dp[i][a[i+1]-j+N]>=mod)dp[i][a[i+1]-j+N]%=mod;
         }
     }
 }

}
        for(int j=-N;j<=N;j++){
            if(dp[n-2][j+N]!=0){
                ans+=dp[n-2][j+N];ans%=mod;
            }
        }
        pw.println(ans);

        pw.close();
    }



    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static PrintWriter pw;

    public static void initReader() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


    }

    public static boolean hasNext() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static String nextLine() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static char nextChar() throws IOException {
        return next().charAt(0);
    }
}

