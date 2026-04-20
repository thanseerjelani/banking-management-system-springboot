package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> employee = employeeRepo.findById(employeeId);
		if (employee.isEmpty()) {
			return null;
		} else {
			return employee.get();
		}
	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		saveEmployee(newEmployee);
		return newEmployee;
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee employee = fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}
}
