package com.myapp.microservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myapp.microservice.model.Department;
import com.myapp.microservice.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${services.employee.url: http://localhost:7070}")
	private String employeeServiceUrl;

	@GetMapping("getAll")
	public ResponseEntity<?> getAllDepartments() {
		try {
			final List<Department> departments = departmentService.findAll();
			return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("getByName")
	public ResponseEntity<?> getByDepartmentName(@RequestParam final String name) {
		try {
			final Department department = departmentService.findByDeptName(name);
			return new ResponseEntity<Department>(department, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{deptid}")
	public ResponseEntity<?> getDepartmentId(@PathVariable final int deptid) {
		try {
			final Department department = departmentService.findByDeptid(deptid);
			return new ResponseEntity<Department>(department, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("reply")
	public ResponseEntity<String> replyToOtherService() {
		return new ResponseEntity<String>(new Date().toString(), HttpStatus.OK);
	}

	@GetMapping("ping")
	public ResponseEntity<String> pingOtherService() {
		return restTemplate.getForEntity(employeeServiceUrl+"/employee/reply", String.class);
	}
}
