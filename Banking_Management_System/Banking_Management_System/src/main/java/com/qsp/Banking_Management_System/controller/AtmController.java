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

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.service.AtmService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AtmController {
	@Autowired
	AtmService atmService;

	@Operation(summary = "Save Atm", description = "API is used to save the Atm")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Atm not found for the given id") })

	@PostMapping("/saveAtm")
	public ResponseEntity<ResponseStructure<Atm>> saveAtm(@RequestBody Atm atm) {
		return atmService.saveAtm(atm);
	}

	@Operation(summary = "fetch Atm", description = "API is used to fetch the Atm")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Atm not found for the given id") })

	@GetMapping("/fetchAtmById")
	public ResponseEntity<ResponseStructure<Atm>> fetchAtmById(@RequestParam int atmId) {
		return atmService.fetchAtmById(atmId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllAtms")
	public List<Atm> fetchAllAtms() {
		return atmService.fetchAllAtms();
	}

	@Operation(summary = "Update Atm", description = "API is used to update the Atm")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Atm not found for the given id") })

	@PutMapping("/updateAtmById")
	public ResponseEntity<ResponseStructure<Atm>> updateAtmById(@RequestParam int oldAtmId, @RequestBody Atm newAtm) {
		return atmService.updateAtmById(oldAtmId, newAtm);
	}

	@Operation(summary = "Delete Atm", description = "API is used to delete the Atm")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Atm not found for the given id") })

	@DeleteMapping("/deleteAtmById")
	public ResponseEntity<ResponseStructure<Atm>> deleteAtmById(@RequestParam int atmId) {
		return atmService.deleteAtmById(atmId);
	}
}
