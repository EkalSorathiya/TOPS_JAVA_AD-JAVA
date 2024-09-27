package com.spring.DiByConstructor;

public class Student {

	private int sid;
	private String fname,lanme,email;

	
	public Student(int sid, String fname, String lanme, String email) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lanme = lanme;
		this.email = email;
	}


	public String toString() {
		return "Student [sid=" + sid + ", fname=" + fname + ", lanme=" + lanme + ", email=" + email + "]";
	}
	
}
