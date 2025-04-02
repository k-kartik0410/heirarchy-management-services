package com.hierarchy.management.system.exceptions;

public class InvalidReferralCodeException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public InvalidReferralCodeException(String message, Throwable cause){
		super(message,cause);
	}
	
	public InvalidReferralCodeException(String message){
		super(message);
	}

}
