import javax.imageio.stream.ImageInputStream;

public class StaticMethod {
    static int a=10;
    static int b;
    {
        System.out.println("Block 1");
    }
    static void meth(int x){
        System.out.println("A: "+a);
        System.out.println("B: "+b);
        System.out.println("X: "+x);
    }
    {
        System.out.println("Block 2");
    }
    public StaticMethod(){
        System.out.println("Static method Constructor");
    }
    static {
        System.out.println("Static block Initialized");
        b=a*4;
    }

    public static void main(String[] args) {
        meth(12);
        StaticMethod s=new StaticMethod();
    }
    {
        System.out.println("Block 3");
    }
}
