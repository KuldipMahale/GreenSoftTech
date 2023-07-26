package com.greensoft.springboot.exception;

import lombok.Data;

@Data
public class ErrorResponse {

	private int statusCode;
	private String message;

	public ErrorResponse() {

	}

	public ErrorResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

}
