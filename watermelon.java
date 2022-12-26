import java.util.Scanner;
public class watermelon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int water = sc.nextInt();
        if(water<2){
            if((water%2)==0){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
/*import java.util.Scanner;
public class Watermelon 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int water=sc.nextInt();
        if(water>2)
        {
        if((water%2)==0)
            System.out.println("YES");
        else
            System.out.println("NO");
        }
        else
            System.out.println("NO");
    }
} */