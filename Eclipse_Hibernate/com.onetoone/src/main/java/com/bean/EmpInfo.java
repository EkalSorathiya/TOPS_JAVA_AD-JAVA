package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPINFO")
public class EmpInfo {

	private int epid;
	private String fname,lname,email;
	private Emp emp;
	
	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "einfo")
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
	
}
