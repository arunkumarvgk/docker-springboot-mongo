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

import com.myapp.microservice.model.Employee;
import com.myapp.microservice.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${services.department.url: http://localhost:7272}")
	private String departmentServiceUrl;

	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{age}")
	public ResponseEntity<List<Employee>> getAllOfGivenAge(@PathVariable final int age) {
		return new ResponseEntity<List<Employee>>(employeeService.findAllOfGivenAge(age), HttpStatus.OK);
	}

	@GetMapping("salary")
	public ResponseEntity<List<Employee>> getAllSalaryGreaterThan(@RequestParam final double greaterThan) {
		return new ResponseEntity<List<Employee>>(employeeService.findAllSalaryGreateThan(greaterThan), HttpStatus.OK);
	}

	@GetMapping("getByName")
	public ResponseEntity<Employee> getByName(@RequestParam final String name) {
		return new ResponseEntity<Employee>(employeeService.findByName(name), HttpStatus.OK);
	}

	@GetMapping("ping")
	public ResponseEntity<String> pingOtherService() {
		return restTemplate.getForEntity(departmentServiceUrl+"/department/reply", String.class);
	}
	
	@GetMapping("reply")
	public ResponseEntity<String> replyToOtherService() {
		return new ResponseEntity<String>(new Date().toString(), HttpStatus.OK);
	}
}
