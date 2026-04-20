package com.qsp.Banking_Management_System.exception;

public class AddressIdNotFound extends RuntimeException {
	private String message = "addressId not found in the DB";

	public String getMessage() {
		return message;
	}

}
