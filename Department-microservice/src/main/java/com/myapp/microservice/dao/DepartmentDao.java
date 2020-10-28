package com.myapp.microservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.microservice.model.Department;

@Repository
public interface DepartmentDao extends MongoRepository<Department, String> {
	public Department findByDeptid(int deptid);
	public Department findByName(String name);
}
