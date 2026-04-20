package com.qsp.Banking_Management_System.exception;

public class BranchIdNotFound extends RuntimeException {
	private String message = "branchId not found in the DB";

	public String getMessage() {
		return message;
	}

}
