package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final Integer serialVersionUID = 1;
 private Integer empId;
 private String empNo;
 private String empName;
 
 public Employee() {
	 
 }
 
 public Employee(Integer empId, String empNo,String empName) {
	 this.empId = empId;
	 this.empNo = empName;
	 this.empName = empName;
	 
 }
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity error
@Column(name = "empid",unique = true, nullable = false )
public Integer getEmpId() {
	return empId;
}

public void setEmpId(Integer empId) {
	this.empId = empId;
}
@Column(name = "empNo",unique = true, nullable = false, length = 10)
public String getEmpNo() {
	return empNo;
}

public void setEmpNo(String empNo) {
	this.empNo = empNo;
}
@Column(name = "empName", length = 20)
public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}
 
 
}
