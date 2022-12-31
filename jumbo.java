import java.io.*; import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    long sum = 0;
		    long max = 0;
		    long side = 0;
		    for(int i=0; i<n; i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        max=Math.max(Math.max(a, b), max);
		        side+=Math.min(a, b);
		    }
		    pw.println(side*2+max*2);
		}
		pw.close();
	}
}
