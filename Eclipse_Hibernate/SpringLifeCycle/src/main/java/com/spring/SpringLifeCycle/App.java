package com.spring.SpringLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext a=new ClassPathXmlApplicationContext("Beans.xml");
    	Student s1=a.getBean("s2",Student.class);
    	System.out.println(s1);
    	a.registerShutdownHook();
    }
}
