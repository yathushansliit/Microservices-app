package com.kayal.employeejpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kayal.employeejpa.shared.Allocation;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(max = 100)
	private String name;

	@NotNull
	@Size(max = 100)
	private String city;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Telephone> telephone;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "project_emp", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
	private List<Project> project;

	private Allocation[] allocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Allocation[] getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation[] allocation) {
		this.allocation = allocation;
	}

}
