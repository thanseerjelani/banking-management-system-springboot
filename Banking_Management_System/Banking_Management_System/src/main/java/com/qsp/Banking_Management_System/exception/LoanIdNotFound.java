package com.qsp.Banking_Management_System.exception;

public class LoanIdNotFound extends RuntimeException {
	private String message = "loanId not found in the DB";

	public String getMessage() {
		return message;
	}
	
}
