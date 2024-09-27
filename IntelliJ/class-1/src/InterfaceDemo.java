interface ifs1{
    void meth1();
}
interface ifs2 extends ifs1{
    void meth2();
}
interface ifs3{
    static void meth3(){
        System.out.println("Meth3");
    }
}
public class InterfaceDemo implements ifs2 {
    public void meth1(){
        System.out.println("Meth1");
    }
    public void meth2(){
        System.out.println("Meth2");
    }

    public static void main(String[] args) {
        InterfaceDemo i=new InterfaceDemo();
        i.meth1();
        i.meth2();
        ifs3.meth3();
    }
}
