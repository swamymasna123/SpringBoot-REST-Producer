package com.swamy.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.swamy.exception.EmployeeNotFoundException;
import com.swamy.model.ErrorMessage;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage>processEmployeeNotFoundException(EmployeeNotFoundException enfe){
		
		ErrorMessage errorMessage = ErrorMessage.builder()
				.message(enfe.getMessage())
				.module("EMPLOYEE")
				.date(new Date().toString())
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build();
		
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

}

