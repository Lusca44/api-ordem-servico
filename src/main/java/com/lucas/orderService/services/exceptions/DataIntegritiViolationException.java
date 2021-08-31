package com.lucas.orderService.services.exceptions;

public class DataIntegritiViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegritiViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegritiViolationException(String message) {
		super(message);
	}
	
	
}
