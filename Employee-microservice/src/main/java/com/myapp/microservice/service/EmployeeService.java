package com.myapp.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.microservice.dao.EmployeeDao;
import com.myapp.microservice.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	public List<Employee> findAllOfGivenAge(final int age) {
		return employeeDao.findAllByAge(age);
	}
	
	public Employee findByName(final String name) {
		return employeeDao.findByName(name);
	}
	
	public List<Employee> findAllSalaryGreateThan(final double salary) {
		return employeeDao.findBySalaryGreaterThan(salary);
	}
}
