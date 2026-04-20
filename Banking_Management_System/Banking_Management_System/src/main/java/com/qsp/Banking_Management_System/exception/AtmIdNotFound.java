package com.qsp.Banking_Management_System.exception;

public class AtmIdNotFound extends RuntimeException {
	private String message = "atmId not found in the DB";

	public String getMessage() {
		return message;
	}

}
