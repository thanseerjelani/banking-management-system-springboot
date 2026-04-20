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

import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.service.BranchService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Branch", description = "API is used to save the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@Operation(summary = "fetch Branch", description = "API is used to fetch the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllBranchs")
	public List<Branch> fetchAllBranchs() {
		return branchService.fetchAllBranchs();
	}

	@Operation(summary = "Update Branch", description = "API is used to update the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,
			@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@Operation(summary = "Delete Branch", description = "API is used to delete the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	
	@Operation(summary = "Add Existing Address To Existing Branch", description = "API is used to Add Existing Address To Existing Branch")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int addressId, @RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	@Operation(summary = "Add Existing Employee To Existing Branch", description = "API is used to Add Existing Employee To Existing Branch")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch(@RequestParam int employeeId, @RequestParam int branchId) {
		return branchService.addExistingEmployeeToExistingBranch(employeeId, branchId);
	}

	@Operation(summary = "Add New Employee To Existing Branch", description = "API is used to Add New Employee To Existing Branch")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))
	
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(@RequestBody Employee newEmployee, @RequestParam int branchId) {
		return branchService.addNewEmployeeToExistingBranch(newEmployee, branchId);
	}
	
	@Operation(summary = "Add Existing Customer To Existing Branch", description = "API is used to Add Existing Customer To Existing Branch")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingCustomerToExistingBranch")
	public Branch addExistingCustomerToExistingBranch(@RequestParam int customerId, @RequestParam int branchId) {
		return branchService.addExistingCustomerToExistingBranch(customerId, branchId);
	}
	
	@Operation(summary = "Add New Customer To Existing Branch", description = "API is used to Add New Customer To Existing Branch")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addNewCustomerToExistingBranch")
	public Branch addNewCustomerToExistingBranch(@RequestBody Customer newCustomer, @RequestParam int branchId) {
		return branchService.addNewCustomerToExistingBranch(newCustomer, branchId);
	}

}
