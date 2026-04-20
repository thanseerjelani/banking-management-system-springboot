package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.BankDao;
import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.exception.BankIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class BankService {
	@Autowired
	BankDao bankDao;

	@Autowired
	ResponseStructure<Bank> responseStructure;

	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank bank) {
		responseStructure.setMessage("Successfully Bank created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("Successfully bank fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BankIdNotFound();
		}
	}

	public List<Bank> fetchAllBanks() {
		return bankDao.fetchAllBanks();
	}

	public ResponseEntity<ResponseStructure<Bank>> updateBankById(int oldBankId, Bank newBank) {
		responseStructure.setMessage("Successfully bank updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBankById(oldBankId, newBank));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("Successfully bank deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BankIdNotFound();
		}
	}

	public Bank addExistingBranchToExistingBank(int bankId, int branchId) {
		return bankDao.addExistingBranchToExistingBank(branchId, bankId);
	}

	public Bank addNewBranchToExistingBank(int bankId, Branch newBranch) {
		return bankDao.addNewBranchToExistingBank(newBranch, bankId);
	}

	public Bank addExistingManagerToExistingBank(int managerId, int bankId) {
		return bankDao.addExistingManagerToExistingBank(managerId, bankId);
	}

	public Bank addExistingAtmToExistingBank(int atmId, int bankId) {
		return bankDao.addExistingAtmToExistingBank(atmId, bankId);
	}

	public Bank addNewAtmToExistingBank(Atm newAtm, int bankId) {
		return bankDao.addNewAtmToExistingBank(newAtm, bankId);
	}
}
