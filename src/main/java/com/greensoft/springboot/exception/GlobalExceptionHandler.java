package com.greensoft.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AlreadyExistsException.class)
	public @ResponseBody ErrorResponse handleAlreadExistsException(AlreadyExistsException alreadyExistsException) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), alreadyExistsException.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ErrorResponse handleNotFoundException(NotFoundException notFoundException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorResponse handleGlobalException(Exception exception) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
	}

}
