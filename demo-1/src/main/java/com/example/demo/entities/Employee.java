package com.example.demo.entities;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//
//import org.springframework.data.annotation.Id;

public class Employee {
 private Long empId;
 private String empNo;
 private String empName;
 
 public Employee() {
	 
 }
 
 public Employee(Long empId, String empNo,String empName) {
	 this.empId = empId;
	 this.empNo = empName;
	 this.empName = empName;
	 
 }

public Long getEmpId() {
	return empId;
}

public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getEmpNo() {
	return empNo;
}

public void setEmpNo(String empNo) {
	this.empNo = empNo;
}
public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}
 
 
}
