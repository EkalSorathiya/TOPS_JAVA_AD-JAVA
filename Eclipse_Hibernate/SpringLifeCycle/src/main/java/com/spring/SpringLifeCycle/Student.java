package com.spring.SpringLifeCycle;

public class Student {

	private String fname,lname,email;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void init()
	{
		System.out.println("Spring Initialized");
	}
	
	public void destory()
	{
		System.out.println("Spring Destoryed");
	}
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}
	
}
