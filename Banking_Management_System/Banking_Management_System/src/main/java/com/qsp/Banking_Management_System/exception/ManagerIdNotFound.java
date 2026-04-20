package com.qsp.Banking_Management_System.exception;

public class ManagerIdNotFound extends RuntimeException {
	private String message = "managerId not found in the DB";

	public String getMessage() {
		return message;
	}

}
