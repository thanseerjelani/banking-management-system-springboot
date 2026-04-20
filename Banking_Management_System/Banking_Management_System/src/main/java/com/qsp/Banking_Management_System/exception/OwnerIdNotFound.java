package com.qsp.Banking_Management_System.exception;

public class OwnerIdNotFound extends RuntimeException {
	private String message = "ownerId not found in the DB";

	public String getMessage() {
		return message;
	}
}
