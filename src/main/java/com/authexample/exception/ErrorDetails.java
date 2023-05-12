package com.authexample.exception;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timeStamp;
	private int statusCode;
	private Map<String, String> errors;
	private String error;
	private String details;

	public ErrorDetails() {

	}

	public ErrorDetails(Date timeStamp, int statusCode, Map<String, String> errors, String details) {
		super();
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.errors = errors;
		this.details = details;
	}

	public ErrorDetails(Date timeStamp, int statusCode, String error, String details) {
		super();
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.error = error;
		this.details = details;
	}

}
