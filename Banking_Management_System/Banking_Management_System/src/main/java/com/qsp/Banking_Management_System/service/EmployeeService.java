package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.EmployeeDao;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.exception.EmployeeIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ResponseStructure<Employee> responseStructure;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setMessage("Successfully Employee created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("Successfully employee fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public List<Employee> fetchAllEmployees() {
		return employeeDao.fetchAllEmployees();
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		responseStructure.setMessage("Successfully employee updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("Successfully employee deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

}
