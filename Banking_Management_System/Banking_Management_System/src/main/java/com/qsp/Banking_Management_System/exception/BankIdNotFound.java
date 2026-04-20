package com.qsp.Banking_Management_System.exception;

public class BankIdNotFound extends RuntimeException {
	private String message = "bankId not found in the DB";

	public String getMessage() {
		return message;
	}

}
