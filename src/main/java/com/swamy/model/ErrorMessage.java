package com.swamy.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private String message;
	private String module;
	private String date;
	private HttpStatus status;
	private Integer statusCode;
}
