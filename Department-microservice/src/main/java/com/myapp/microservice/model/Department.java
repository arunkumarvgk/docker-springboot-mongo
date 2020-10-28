package com.myapp.microservice.model;

import org.springframework.data.annotation.Id;

public class Department {
	@Id
	private String id;
	private int deptid;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptid=" + deptid + ", name=" + name + "]";
	}
}