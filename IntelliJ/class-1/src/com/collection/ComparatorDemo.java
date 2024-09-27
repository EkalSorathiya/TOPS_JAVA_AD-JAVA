package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo implements Comparator<Emp> {


    public int compare(Emp e1, Emp e2) {
        int result=0;
        if(e1.getSalary()>e2.getSalary()){
            result =-1;
        }
        else if(e1.getSalary()<e2.getSalary()){
            result =1;
        }
        else if(e1.getSalary()==e2.getSalary()){
            result =0;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Emp> list=new ArrayList<>();
        Emp e1=new Emp();
        e1.setEid(1);
        e1.setEname("Ekal");
        e1.setSalary(100000);
        Emp e2=new Emp();
        e2.setEid(2);
        e2.setEname("mihir");
        e2.setSalary(25000);
        Emp e3=new Emp();
        e3.setEid(3);
        e3.setEname("Chirag");
        e3.setSalary(50000);
        Emp e4=new Emp();
        e4.setEid(4);
        e4.setEname("Jenil");
        e4.setSalary(10000);

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        Collections.sort(list,new ComparatorDemo());
        for(Emp e:list)
        {
            System.out.println("Eid :"+e.getEid()+" Ename: "+e.getEname()+" Salary : "+e.getSalary());
        }

    }
}
