package com.hierarchy.management.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hierarchy.management.system.model.responses.ErrorResponseModel;

@ControllerAdvice
public class GlobalExceptionHandeler {
	
	@ExceptionHandler(value = InvalidReferralCodeException.class)
	public ResponseEntity<ErrorResponseModel> handleInvalidReferralCodeException(InvalidReferralCodeException ex){
		return new ResponseEntity<ErrorResponseModel>(new ErrorResponseModel("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
		
	}

}
