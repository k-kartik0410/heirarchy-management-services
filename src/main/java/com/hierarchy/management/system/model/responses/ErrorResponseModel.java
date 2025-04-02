package com.hierarchy.management.system.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseModel {
	
	@JsonProperty("errorType")
	private String errorType;
	
	@JsonProperty("errorMessage")
	private String errorMessage;

	public ErrorResponseModel(String errorType, String errorMessage) {
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
