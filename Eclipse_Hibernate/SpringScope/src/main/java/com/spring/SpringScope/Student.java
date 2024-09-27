package com.spring.SpringScope;

public class Student {
	private int id;
	private String fname,lanme,email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLanme() {
		return lanme;
	}
	public void setLanme(String lanme) {
		this.lanme = lanme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lanme=" + lanme + ", email=" + email + "]";
	}
	

}
