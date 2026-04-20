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

import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.service.ManagerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	@Operation(summary = "Save Manager", description = "API is used to save Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully saved Manager"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })

	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@Operation(summary = "fetch Manager By Id", description = "API is used to fetch Manager By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched Manager"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })

	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllManagers")
	public List<Manager> fetchAllManagers() {
		return managerService.fetchAllManagers();
	}
	
	@Operation(summary = "Update Manager By Id", description = "API is used to Update Manager By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Updated Manager"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })

	@PutMapping("/updateManagerById")
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(@RequestParam int oldManagerId, @RequestBody Manager newManager) {
		return managerService.updateManagerById(oldManagerId, newManager);
	}
	
	@Operation(summary = "Delete Manager By Id", description = "API is used to Delete Manager By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Deleted Manager"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })

	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}
}
