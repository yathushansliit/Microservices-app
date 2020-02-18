package com.kayal.employeejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kayal.employeejpa.model.Employee;
import com.kayal.employeejpa.repository.EmployeeRepository;
import com.kayal.employeejpa.shared.Allocation;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Optional<Employee> employeeEntity = employeeRepository.findById(id);
		Employee updatedEntity = new Employee();

		if (employeeEntity.isPresent()) {
			updatedEntity.setId(id);
			updatedEntity.setName(employee.getName());
			updatedEntity.setCity(employee.getCity());
			return employeeRepository.save(updatedEntity);

		}
		return null;
	}

	@Override
	public Employee findEmployee(Integer id) {
		Optional<Employee> employee1 = employeeRepository.findById(id);

		if (employee1.isPresent()) {
			Allocation[] allocations = fetchAllocation(id);
			Employee emp = employee1.get();
			emp.setAllocation(allocations);
			return emp;
		}
		return null;
	}

	public Allocation[] fetchAllocation(Integer id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<Allocation[]> allocationResponse = restTemplate.exchange(
				"http://localhost:8081/allocation/" + id, HttpMethod.GET, httpEntity, Allocation[].class);
		if (allocationResponse.getStatusCode().value() == 200) {
			return allocationResponse.getBody();
		}
		return new Allocation[0];
	}
}
