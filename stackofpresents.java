import java.util.Scanner;
import java.util.HashSet;

public class stackofpresents {
    private static int current;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] a, b;
            a = new int[n];
            for(int i = 0; i<n; i++) a[i] = sc.nextInt();
            b = new int[m];
            for(int i =0; i<m; i++) b[i] = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            int currnet = 0;
            long time = 0;
            for (int i = 0; i < m; i++) {
                if (hs.contains(b[i])) {
                    time++;
                    hs.remove(b[i]);
                } else {
                    while (a[current] != b[i]) {
                        hs.add(a[current]);
                        current++;
                    }
                    time = time + 2 * hs.size() + 1;
                    current++;
                }
            }
            System.out.println(time);
        }
    }
}
