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
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.service.CustomerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@Operation(summary = "Save Customer", description = "API is used to save the customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@Operation(summary = "fetch Customer", description = "API is used to fetch the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })

	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}
	
	@Operation(summary = "fetch All Accounts", description = "API is used to fetch All the Accounts")
	@ApiResponses(value = @ApiResponse(responseCode = "200", description = "Successfully fetched"))

	@GetMapping("/fetchAllCustomers")
	public List<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}

	@Operation(summary = "Update Customer", description = "API is used to update the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })

	@PutMapping("/updateCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestParam int oldCustomerId,
			@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldCustomerId, newCustomer);
	}

	@Operation(summary = "Delete Customer", description = "API is used to delete the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })

	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	
	@Operation(summary = "Add Existing Account To Existing Customer", description = "API is used to Add Existing Account To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))


	@PutMapping("/addExistingAccountToExistingCustomer")
	public Customer addExistingAccountToExistingCustomer(@RequestParam int accountId, @RequestParam int customerId) {
		return customerService.addExistingAccountToExistingCustomer(accountId, customerId);
	}
	
	@Operation(summary = "Add New Account To Existing Customer", description = "API is used to Add New Account To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))


	@PutMapping("/addNewAccountToExistingCustomer")
	public Customer addNewAccountToExistingCustomer(@RequestBody Account newAccount, @RequestParam int customerId) {
		return customerService.addNewAccountToExistingCustomer(newAccount, customerId);
	}
	
	@Operation(summary = "Add Existing Loan To Existing Customer", description = "API is used to Add Existing Loan To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingLoanToExistingCustomer")
	public Customer addExistingLoanToExistingCustomer(@RequestParam int loanId, @RequestParam int customerId) {
		return customerService.addExistingLoanToExistingCustomer(loanId, customerId);
	}
	
	@Operation(summary = "Add New Loan To Existing Customer", description = "API is used to Add New Loan To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addNewLoanToExistingCustomer")
	public Customer addNewLoanToExistingCustomer(@RequestBody Loan newLoan, @RequestParam int customerId) {
		return customerService.addNewLoanToExistingCustomer(newLoan, customerId);
	}
	
	@Operation(summary = "Add Existing Card To Existing Customer", description = "API is used to Add Existing Card To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addExistingCardToExistingCustomer")
	public Customer addExistingCardToExistingCustomer(@RequestParam int cardId, @RequestParam int customerId) {
		return customerService.addExistingCardToExistingCustomer(cardId, customerId);
	}
	
	@Operation(summary = "Add New Card To Existing Customer", description = "API is used to Add New Card To Existing Customer")
	@ApiResponses(value = @ApiResponse(responseCode = "200"))

	@PutMapping("/addNewCardToExistingCustomer")
	public Customer addNewCardToExistingCustomer(@RequestBody Card newCard, @RequestParam int customerId) {
		return customerService.addNewCardToExistingCustomer(newCard, customerId);
	}
}
