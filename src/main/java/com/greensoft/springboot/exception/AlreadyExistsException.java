package com.greensoft.springboot.exception;

import lombok.Data;

@Data
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public AlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public AlreadyExistsException() {

	}
}
