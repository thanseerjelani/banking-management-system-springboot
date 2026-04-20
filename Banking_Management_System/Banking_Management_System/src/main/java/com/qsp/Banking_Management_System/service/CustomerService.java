package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.CustomerDao;
import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.exception.CustomerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ResponseStructure<Customer> responseStructure;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		responseStructure.setMessage("Successfully Customer created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully customer fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public List<Customer> fetchAllCustomers() {
		return customerDao.fetchAllCustomers();
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(int oldCustomerId, Customer newCustomer) {
		responseStructure.setMessage("Successfully customer updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully customer deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public Customer addExistingAccountToExistingCustomer(int accountId, int customerId) {
		return customerDao.addExistingAccountToExistingCustomer(accountId, customerId);
	}

	public Customer addNewAccountToExistingCustomer(Account newAccount, int customerId) {
		return customerDao.addNewAccountToExistingCustomer(newAccount, customerId);
	}

	public Customer addExistingLoanToExistingCustomer(int loanId, int customerId) {
		return customerDao.addExistingLoanToExistingCustomer(loanId, customerId);
	}

	public Customer addNewLoanToExistingCustomer(Loan newLoan, int customerId) {
		return customerDao.addNewLoanToExistingCustomer(newLoan, customerId);
	}

	public Customer addExistingCardToExistingCustomer(int cardId, int customerId) {
		return customerDao.addExistingCardToExistingCustomer(cardId, customerId);
	}

	public Customer addNewCardToExistingCustomer(Card newCard, int customerId) {
		return customerDao.addNewCardToExistingCustomer(newCard, customerId);
	}

}
