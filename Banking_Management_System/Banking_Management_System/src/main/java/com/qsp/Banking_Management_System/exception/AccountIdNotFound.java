package com.qsp.Banking_Management_System.exception;

public class AccountIdNotFound extends RuntimeException {
	private String message = "accountId not found in the DB";

	public String getMessage() {
		return message;
	}
}
