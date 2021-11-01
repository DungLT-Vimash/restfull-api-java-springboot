package com.example.demo.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;
@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	public Employee getEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
		
	}
	
	public Employee addEmployee(Employee empForm) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empForm);
		return empForm;
	}
	
	public Employee updateEmployee(Employee form) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, form.getEmpId());
		emp.setEmpName(form.getEmpName());
		emp.setEmpNo(form.getEmpNo());
		session.update(emp);
		return emp;
	}
	
	public void deleteEmployee(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp);
	}
	
	public List<Employee>getAllEmployees(){
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Employee> listEmployee = (List<Employee>) session.createQuery(" FROM " + Employee.class.getName()).list();
		return listEmployee;
	}
	
	
}
