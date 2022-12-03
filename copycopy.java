import java.util.HashSet;
import java.util.Scanner;
public class copycopy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            HashSet hs = new HashSet<>();
            for (int i = 0; i < n; i++) hs.add(sc.nextInt());
            sb.append(hs.size()+"\n");
        }
        System.out.println(sb);
    }
}
