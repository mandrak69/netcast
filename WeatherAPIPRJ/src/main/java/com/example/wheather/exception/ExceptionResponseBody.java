package com.example.wheather.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ExceptionResponseBody {

	private String message;

	private HttpStatus httpStatus;

	private List<String> errors;

	

	public ExceptionResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
