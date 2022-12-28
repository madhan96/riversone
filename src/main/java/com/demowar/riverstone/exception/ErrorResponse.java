package com.demowar.riverstone.exception;

import java.util.HashMap;
import java.util.Map;


public class ErrorResponse {
	private String errorMessage;
	
	private String details;
	
	private String errorCode;
	
	private boolean multiple;
		
	private HashMap<String, String> errorDetails;
	

	public ErrorResponse(String errorMessage, String details, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
		this.errorCode = errorCode;
	}
	
	public ErrorResponse(Map<String,String> errorDetails,String details,String errorCode) {
		super();
		this.errorDetails=(HashMap<String, String>) errorDetails;
		this.details=details;
		this.errorCode=errorCode;
		this.multiple=true;	
	}

	public boolean isMultiple() {
		return multiple;
	}

	public HashMap<String, String> getErrorDetails() {
		return errorDetails;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
}
