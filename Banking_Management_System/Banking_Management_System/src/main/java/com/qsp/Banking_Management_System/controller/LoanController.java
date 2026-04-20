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

import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.service.LoanService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	
	@Operation(summary = "Save Loan", description = "API is used to save the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })

	@PostMapping("/saveLoan")
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}
	
	@Operation(summary = "fetch Loan By Id", description = "API is used to fetch the Loan By Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })

	@GetMapping("/fetchLoanById")
	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllLoans")
	public List<Loan> fetchAllLoans() {
		return loanService.fetchAllLoans();
	}
	
	@Operation(summary = "Update Loan By Id", description = "API is used to update the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })

	@PutMapping("/updateLoanById")
	public ResponseEntity<ResponseStructure<Loan>> updateLoanById(@RequestParam int oldLoanId,
			@RequestBody Loan newLoan) {
		return loanService.updateLoanById(oldLoanId, newLoan);
	}
	
	@Operation(summary = "Delete Loan", description = "API is used to delete the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })

	@DeleteMapping("/deleteLoanById")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(@RequestParam int loanId) {
		return loanService.deleteLoanById(loanId);
	}
}
