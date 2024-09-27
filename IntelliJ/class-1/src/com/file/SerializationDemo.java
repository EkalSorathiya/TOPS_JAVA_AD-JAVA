package com.file;

import java.io.*;

class Student implements Serializable {
    int rno;
    String name;
    double per;

    public Student(int rno, String name, double per) {
        this.rno = rno;
        this.name = name;
        this.per = per;
    }

    public String toString() {
        return "Roll No.: "+rno+"\nStudent Nmae: "+name+"\nPercentage"+per;

    }
}
public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        Student s1=new Student(1,"Ekal",90);
        FileOutputStream fos=new FileOutputStream("Ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.flush();
        oos.close();
        System.out.println("Object Return Successfully");

        FileInputStream fis=new FileInputStream("Ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Student s2=(Student) ois.readObject();
        ois.close();
        System.out.println(s2);

    }
}
