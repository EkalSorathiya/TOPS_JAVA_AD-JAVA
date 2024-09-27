public class MethodOverloading {
    void test(){
        System.out.println("test with no arguments");
    }
    void test(int a){
        System.out.println("test with 1 arguments");
    }
    void test(int a,int b)
    {
        System.out.println("test with 2 arguments");
    }

    public static void main(String[] args) {
        MethodOverloading m=new MethodOverloading();
        m.test();
        m.test(1);
        m.test(1,2);

    }
}
