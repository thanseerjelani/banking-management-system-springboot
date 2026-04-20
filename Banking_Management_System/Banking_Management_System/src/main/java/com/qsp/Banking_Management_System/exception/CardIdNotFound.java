package com.qsp.Banking_Management_System.exception;

public class CardIdNotFound extends RuntimeException {
	private String message = "cardId not found in the DB";

	public String getMessage() {
		return message;
	}
	
}
