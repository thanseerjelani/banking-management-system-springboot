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

import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.service.AccountService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	@Operation(summary = "Save Account", description = "API is used to save the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })

	@PostMapping("/saveAccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@Operation(summary = "fetch Account", description = "API is used to fetch the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })

	@GetMapping("/fetchAccountById")
	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}

	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllAccounts")
	public List<Account> fetchAllAccounts() {
		return accountService.fetchAllAccounts();
	}

	@Operation(summary = "Update Account", description = "API is used to update the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })

	@PutMapping("/updateAccountById")
	public ResponseEntity<ResponseStructure<Account>> updateAccountById(@RequestParam int oldAccountId,
			@RequestBody Account newAccount) {
		return accountService.updateAccountById(oldAccountId, newAccount);
	}

	@Operation(summary = "Delete Account", description = "API is used to delete the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Account not found for the given id") })

	@DeleteMapping("/deleteAccountById")
	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}
}
