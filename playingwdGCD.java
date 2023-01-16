import java.io.*;
import java.util.*;
import java.lang.*;


public class playingwdGCD {
    static FastScanner sc = new FastScanner();
    static long max = 0;
    public static void main(String[] args){
        int t = sc.nextInt();
        while( t--> 0){
            solve();
        }
        
    }

    public static void solve() {
        int n = sc.nextInt();
        int[] arr = new int[n+2]; 
        arr[0] = 1;
        arr[n+1] = 1;

        for(int i = 1;i<=n;i++) arr[i] = sc.nextInt();
        
        int[] arrb = new int[n+2];
        for(int i = 1;i<n+2;i++){
            arrb[i] = lcm(arr[i], arr[i-1], gcd(arr[i], arr[i-1]));
        }
        for(int i =  1;i<=n;i++){
            if(arr[i] != gcd(arrb[i], arrb[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    // gcd method returns the GCD of a and b
    static int gcd(int a, int b) {
        
        // if b=0, a is the GCD
        if (b == 0)
            return a;
        
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
  
    // lcm() method returns the LCM of a and b
    static int lcm(int a, int b, int gcdValue)
    {
        return Math.abs(a * b) / gcdValue;
    }
    
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
		    return Double.parseDouble(next());
		}
}
}