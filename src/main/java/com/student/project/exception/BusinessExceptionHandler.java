package com.student.project.exception;

public class BusinessExceptionHandler  extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	private String errorCode;
	
	private String errorMessage;
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BusinessExceptionHandler(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	public BusinessExceptionHandler() {
		
	}
	

}
