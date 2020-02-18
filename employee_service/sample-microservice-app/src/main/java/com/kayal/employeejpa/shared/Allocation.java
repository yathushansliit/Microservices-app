package com.kayal.employeejpa.shared;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Allocation {
	
	@Id
	private int id;
	private String empId;
	private String start;
	private String end;
	private int projectCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

}
