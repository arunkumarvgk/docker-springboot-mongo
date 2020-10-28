package com.myapp.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.microservice.dao.DepartmentDao;
import com.myapp.microservice.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	public Department findByDeptid(final int deptid) {
		return departmentDao.findByDeptid(deptid);
	}
	
	public Department findByDeptName(final String name) {
		return departmentDao.findByName(name);
	}
}
