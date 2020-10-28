package com.myapp.microservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.microservice.model.Employee;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, String> {

	public Employee findByName(String name);
	public List<Employee> findAllByAge(int age);
	public List<Employee> findBySalaryGreaterThan(double salary);
}
