import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter value of A:");
        a=sc.nextInt();
        System.out.print("Enter value of B:");
        b=sc.nextInt();
        System.out.print("Enter value of C:");
        c=sc.nextInt();
        if(a>b){
            if(a>c)
            {
                System.out.println("A is greater number!");
            }
            else {
                System.out.println("C is greater number!");
            }
        }
        else{
            if(b>c)
            {
                System.out.println("B is greater number!!");
            }
            else{
                System.out.println("C is Greater number!!");
            }
        }
    }
}

class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n:");
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for(int i=n;i>=0;i--)
        {
            for(int k=0;k<=n-i;k++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
