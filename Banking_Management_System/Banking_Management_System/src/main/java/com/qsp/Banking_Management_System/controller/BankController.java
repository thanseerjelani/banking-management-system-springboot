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
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.service.BankService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BankController {
	@Autowired
	BankService bankService;

	@Operation(summary = "Save Bank", description = "API is used to save the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })

	@PostMapping("/saveBank")
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}

	@Operation(summary = "fetch Bank", description = "API is used to fetch the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })

	@GetMapping("/fetchBankById")
	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}

	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllBanks")
	public List<Bank> fetchAllBanks() {
		return bankService.fetchAllBanks();
	}

	@Operation(summary = "Update Bank", description = "API is used to update the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })

	@PutMapping("/updateBankById")
	public ResponseEntity<ResponseStructure<Bank>> updateBankById(@RequestParam int oldBankId,
			@RequestBody Bank newBank) {
		return bankService.updateBankById(oldBankId, newBank);
	}

	@Operation(summary = "Delete Bank", description = "API is used to delete the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })

	@DeleteMapping("/deleteBankById")
	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}

	@Operation(summary = "Add Existing Branch To Existing Bank", description = "API is used to Add Existing Branch To Existing Bank")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingBranchToExistingBank")
	public Bank addExistingBranchToExistingBank(@RequestParam int bankId, @RequestParam int branchId) {
		return bankService.addExistingBranchToExistingBank(bankId, branchId);
	}

	@Operation(summary = "Add New Branch To Existing Bank", description = "API is used to Add New Branch To Existing Bank")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addNewBranchToExistingBank")
	public Bank addNewBranchToExistingBank(@RequestParam int bankId, @RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}

	@Operation(summary = "Add Existing Manager To Existing Bank", description = "API is used to Add Existing Manager To Existing Bank")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingManagerToExistingBank")
	public Bank addExistingManagerToExistingBank(@RequestParam int managerId, @RequestParam int bankId) {
		return bankService.addExistingManagerToExistingBank(managerId, bankId);
	}

	@Operation(summary = "Add Existing Atm To Existing Bank", description = "API is used to Add Existing Atm To Existing Bank")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingAtmToExistingBank")
	public Bank addExistingAtmToExistingBank(@RequestParam int atmId, @RequestParam int bankId) {
		return bankService.addExistingAtmToExistingBank(atmId, bankId);
	}

	@Operation(summary = "Add New Atm To Existing Bank", description = "API is used to Add New Atm To Existing Bank")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addNewAtmToExistingBank")
	public Bank addNewAtmToExistingBank(@RequestBody Atm newAtm, @RequestParam int bankId) {
		return bankService.addNewAtmToExistingBank(newAtm, bankId);
	}

}
