package com.authexample.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private String description;
	private int statusCode;

	public ResourceNotFoundException(String message) {
		this.message = message;
	}
}
