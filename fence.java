import java.util.Scanner;
public class fence {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long a = sc.nextInt(), b=sc.nextInt(), c = sc.nextInt();
            System.out.println(a+b+c-1);
        }
    }
}
