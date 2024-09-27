class Box{
    double h,b,d;
    Box(){
        System.out.println("Default constructor called");
        b=10;
        h=20;
        d=50;
    }
    Box(double h1,double b1,double d1)
    {
        System.out.println("Parameterized Constructor");
        b=b1;
        h=h1;
        d=d1;
    }

    Box(Box x)
    {
        System.out.println("Copy Constructor Called");
        h=x.h;
        b=x.b;
        d=x.d;
    }
    void volume(){
        System.out.println("Volume :"+(h*b*d));
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Box b1=new Box();
        b1.volume();

        Box b2=new Box(2,3,4);
        b2.volume();

        Box b3=new Box(b1);
        b3.volume();
    }
}
