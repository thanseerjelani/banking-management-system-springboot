package com.qsp.Banking_Management_System.exception;

public class EmployeeIdNotFound extends RuntimeException {
	private String message = "employeeId not found in the DB";

	public String getMessage() {
		return message;
	}

}
