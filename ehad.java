import java.util.Scanner;
public class ehad {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            sb.append(1+" "+(x-1)+"\n");
        }
        System.out.println(sb);
    }
}
