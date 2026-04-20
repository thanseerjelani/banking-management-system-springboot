package com.qsp.Banking_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.service.EmployeeService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "Save Employee", description = "API is used to save the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@Operation(summary = "fetch Employee", description = "API is used to fetch the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })

	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllEmployees")
	public List<Employee> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();
	}
	
	@Operation(summary = "Update Employee", description = "API is used to update the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })

	@PutMapping("/updateEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@RequestParam int oldEmployeeId,
			@RequestBody Employee newEmployee) {
		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
	
	@Operation(summary = "Delete Employee", description = "API is used to delete the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })

	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}
}
