package com.spring.SpringHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext a=new ClassPathXmlApplicationContext("Beans.xml");
		Student s1=a.getBean("s1",Student.class);
		System.out.println(s1);
	}
}
  