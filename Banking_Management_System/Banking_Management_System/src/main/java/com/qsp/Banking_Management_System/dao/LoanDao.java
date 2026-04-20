package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.repo.LoanRepo;

@Repository
public class LoanDao {
	@Autowired
	LoanRepo loanRepo;

	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}

	public Loan fetchLoanById(int loanId) {
		Optional<Loan> loan = loanRepo.findById(loanId);
		if (loan.isEmpty()) {
			return null;
		} else {
			return loan.get();
		}
	}

	public List<Loan> fetchAllLoans() {
		return loanRepo.findAll();
	}

	public Loan updateLoanById(int oldLoanId, Loan newLoan) {
		newLoan.setLoanId(oldLoanId);
		saveLoan(newLoan);
		return newLoan;
	}

	public Loan deleteLoanById(int loanId) {
		Loan loan = fetchLoanById(loanId);
		loanRepo.delete(loan);
		return loan;
	}
}
