package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.repo.AccountRepo;

@Repository
public class AccountDao {
	@Autowired
	AccountRepo accountRepo;

	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	public Account fetchAccountById(int accountId) {
		Optional<Account> account = accountRepo.findById(accountId);
		if (account.isEmpty()) {
			return null;
		} else {
			return account.get();
		}
	}

	public List<Account> fetchAllAccounts() {
		return accountRepo.findAll();
	}

	public Account updateAccountById(int oldAccountId, Account newAccount) {
		newAccount.setAccountId(oldAccountId);
		saveAccount(newAccount);
		return newAccount;
	}

	public Account deleteAccountById(int AccountId) {
		Account account = fetchAccountById(AccountId);
		accountRepo.delete(account);
		return account;
	}
}
