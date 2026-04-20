package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.AccountDao;
import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.exception.AccountIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;

	@Autowired
	ResponseStructure<Account> responseStructure;

	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		responseStructure.setMessage("Successfully Account created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("Successfully account fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(accountDao.fetchAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AccountIdNotFound();
		}
	}

	public List<Account> fetchAllAccounts() {
		return accountDao.fetchAllAccounts();
	}

	public ResponseEntity<ResponseStructure<Account>> updateAccountById(int oldAccountId, Account newAccount) {
		responseStructure.setMessage("Successfully account updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.updateAccountById(oldAccountId, newAccount));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("Successfully account deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.deleteAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AccountIdNotFound();
		}
	}

}
