package com.bean;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.catalina.ha.backend.CollectedInfo;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMP2")
public class Dept {
	
	private int did;
	private String dname;
	private double salary;
	private Collection<Emp1> emp;
	
	@Id
	@GenericGenerator(name = "inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	@Column(name = "DNAME")
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Column(name = "SALARY")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "dept")
	public Collection<Emp1> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Emp1> emp) {
		this.emp = emp;
	}

	
}
