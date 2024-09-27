class Student{
    int roll;
    String name;
    public Student(){
        System.out.println("Default constructor called");
    }
    public  Student(int roll, String name){
        this();
        System.out.println("Parameterised constructor");
        this.roll=roll;
        this.name=name;
    }
    void display(Student s){
        System.out.println("Roll no.: "+s.roll);
        System.out.println("Student name : "+s.name);
    }
    void show(){
        this.display(this);
    }

}
public class thisKeyword {

    public static void main(String[] args) {
        Student s1=new Student(1,"Ekal");
        s1.show();
    }
}
