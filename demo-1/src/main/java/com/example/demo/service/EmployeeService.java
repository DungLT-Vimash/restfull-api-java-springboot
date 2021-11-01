package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee getEmployee(Long empId) {
		return employeeDao.getEmployee(empId);
		
	}
	public Employee addEmployee(Employee empForm) {
		return employeeDao.addEmployee(empForm);
	}
	public Employee updateEmployee(Employee empForm) {
		return employeeDao.updateEmployee(empForm);
	}
	public void deleteEmployee(Long empId) {
		employeeDao.deleteEmployee(empId);
	}
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
}
