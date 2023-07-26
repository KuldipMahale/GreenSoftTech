package com.greensoft.springboot.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	public NotFoundException() {

	}
}
