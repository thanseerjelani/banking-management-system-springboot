package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	AccountDao accountDao;

	@Autowired
	LoanDao loanDao;

	@Autowired
	CardDao cardDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		if (customer.isEmpty()) {
			return null;
		} else {
			return customer.get();
		}
	}

	public List<Customer> fetchAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer updateCustomerById(int oldCustomerId, Customer newCustomer) {
		newCustomer.setCustomerId(oldCustomerId);
		saveCustomer(newCustomer);
		return newCustomer;
	}

	public Customer deleteCustomerById(int customerId) {
		Customer customer = fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}

	public Customer addExistingAccountToExistingCustomer(int accountId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Account> accounts = customer.getAccounts();
		Account account = accountDao.fetchAccountById(accountId);
		accounts.add(account);
		customer.setAccounts(accounts);
		return saveCustomer(customer);
	}

	public Customer addNewAccountToExistingCustomer(Account newAccount, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Account> accounts = customer.getAccounts();
		accounts.add(newAccount);
		customer.setAccounts(accounts);
		return saveCustomer(customer);
	}

	public Customer addExistingLoanToExistingCustomer(int loanId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Loan> loans = customer.getLoans();
		Loan loan = loanDao.fetchLoanById(loanId);
		loans.add(loan);
		customer.setLoans(loans);
		return saveCustomer(customer);
	}

	public Customer addNewLoanToExistingCustomer(Loan newLoan, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Loan> loans = customer.getLoans();
		loans.add(newLoan);
		customer.setLoans(loans);
		return saveCustomer(customer);
	}

	public Customer addExistingCardToExistingCustomer(int cardId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Card> cards = customer.getCards();
		Card card = cardDao.fetchCardById(cardId);
		cards.add(card);
		customer.setCards(cards);
		return saveCustomer(customer);
	}

	public Customer addNewCardToExistingCustomer(Card newCard, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Card> cards = customer.getCards();
		cards.add(newCard);
		customer.setCards(cards);
		return saveCustomer(customer);
	}
}
