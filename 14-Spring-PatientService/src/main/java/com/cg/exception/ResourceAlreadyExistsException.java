package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceAlreadyExistsException extends Exception{
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
