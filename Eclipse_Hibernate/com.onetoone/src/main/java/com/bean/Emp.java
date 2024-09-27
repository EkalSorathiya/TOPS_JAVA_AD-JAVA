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
@Table(name = "EMP1")
public class Emp {

	private int eid;
	private String dept,job;
	private EmpInfo einfo;
	
	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public EmpInfo getEinfo() {
		return einfo;
	}
	public void setEinfo(EmpInfo einfo) {
		this.einfo = einfo;
	}
		
}
