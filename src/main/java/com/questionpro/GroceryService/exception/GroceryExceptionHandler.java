package com.questionpro.GroceryService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.questionpro.GroceryService.utils.GenericResponse;

@RestControllerAdvice
public class GroceryExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse<String>> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
		//reading message from ResourceNotFoundException class instance
		String message = resourceNotFoundException.getMessage();
		return new ResponseEntity<GenericResponse<String>>(
				new GenericResponse<String>(message, "Not Found", "False"), HttpStatus.NOT_FOUND);
	}

}
