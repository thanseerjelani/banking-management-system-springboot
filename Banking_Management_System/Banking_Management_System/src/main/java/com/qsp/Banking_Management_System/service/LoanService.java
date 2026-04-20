package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.LoanDao;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.exception.LoanIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;

@Service
public class LoanService {
	@Autowired
	LoanDao loanDao;

	@Autowired
	ResponseStructure<Loan> responseStructure;

	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan) {
		responseStructure.setMessage("Successfully Loan created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("Successfully loan fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.fetchLoanById(loanId));
			return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new LoanIdNotFound();
		}
	}

	public List<Loan> fetchAllLoans() {
		return loanDao.fetchAllLoans();
	}

	public ResponseEntity<ResponseStructure<Loan>> updateLoanById(int oldLoanId, Loan newLoan) {
		responseStructure.setMessage("Successfully loan updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.updateLoanById(oldLoanId, newLoan));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("Successfully loan deleted in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.deleteLoanById(loanId));
			return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.OK);
		} else {
			throw new LoanIdNotFound();
		}
	}

}
