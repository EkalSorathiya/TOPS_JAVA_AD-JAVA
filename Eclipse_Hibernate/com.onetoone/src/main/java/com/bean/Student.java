package com.bean;

import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Students")
public class Student {
	
	private int sid;
	private String fname,lname;
	private Set<Courses> courses;
	
	@Id
	@GenericGenerator(name = "inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "CID"),joinColumns = @JoinColumn(name = "SID"))
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
	
	

}
