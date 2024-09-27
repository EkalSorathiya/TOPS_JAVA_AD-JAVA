import javax.swing.*;
import java.util.Scanner;

public class Throws_Demo {
    public static void demo () throws ArithmeticException, ArrayIndexOutOfBoundsException, IndexOutOfBoundsException
    {
        int x;
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter X: ");
        x = sc.nextInt();

        if (x > 0) {
            System.out.println("Square of " + x + " is " + (x * x));

        } else {
            throw new ArithmeticException();
        }
    }
    public static void main(String[] args) {
        try{
            demo();
        }catch (Exception e){
            System.out.println("Exception Caught");
        }
        finally {
            System.out.println("Finally Caught");
        }
    }
}
