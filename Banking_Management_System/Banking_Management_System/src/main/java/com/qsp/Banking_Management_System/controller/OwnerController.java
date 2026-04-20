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

import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.service.OwnerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@Operation(summary = "fetch Owner By Id", description = "API is used to fetch Owner By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched Owner"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllOwners")
	public List<Owner> fetchAllOwners() {
		return ownerService.fetchAllOwners();
	}
	
	@Operation(summary = "Update Owner By Id", description = "API is used to Update Owner By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated Owner"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })

	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerId,
			@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	
	@Operation(summary = "delete Owner By Id", description = "API is used to delete Owner By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully deleted Owner"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })

	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	
	@Operation(summary = "Add Existing Bank To Existing Owner", description = "API is used to Add Existing Bank To Existing Owner")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingBankToExistingOwner")
	public Owner addExistingBankToExistingOwner(@RequestParam int ownerId, @RequestParam int bankId) {
		return ownerService.addExistingBankToExistingOwner(ownerId, bankId);
	}
}
