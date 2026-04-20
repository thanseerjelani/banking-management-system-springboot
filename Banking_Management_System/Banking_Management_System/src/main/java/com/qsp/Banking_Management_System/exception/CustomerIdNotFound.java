package com.qsp.Banking_Management_System.exception;

public class CustomerIdNotFound extends RuntimeException {
	private String message = "customerId not found in the DB";

	public String getMessage() {
		return message;
	}

}
