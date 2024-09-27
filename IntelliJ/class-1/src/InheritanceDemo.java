import java.util.Scanner;

class A{
    int a;
    Scanner sc =new Scanner(System.in);
    void getA(){
        System.out.print("Enter A:");
        a=sc.nextInt();
    }
    void printA(){
        System.out.println("A: "+a);
    }
}

class B extends A
{
    int b;
    Scanner sc =new Scanner(System.in);
    void getB(){
        System.out.print("Enter B:");
        b=sc.nextInt();
    }
    void printB(){
        System.out.println("B: "+b);
    }
}
class C extends A
{
    int c;
    Scanner sc =new Scanner(System.in);
    void getC(){
        System.out.print("Enter C:");
        c=sc.nextInt();
    }
    void printC(){
        System.out.println("C: "+c);
    }
}


public class InheritanceDemo {
    public static void main(String[] args) {
        B b1=new B();
        C c1=new C();
        b1.getA();
        b1.getB();
        c1.getC();
        c1.printA();
        b1.printB();
        c1.printC();
    }
}
