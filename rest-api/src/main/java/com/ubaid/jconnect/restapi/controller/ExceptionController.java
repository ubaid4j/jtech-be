package com.ubaid.jconnect.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ubaid.jconnect.restapi.exception.ExceptionBody;
import com.ubaid.jconnect.restapi.exception.JTechException;


@ControllerAdvice
public class ExceptionController
{
	@ExceptionHandler
	public ResponseEntity<ExceptionBody> handleException(JTechException exp)
	{
		String message = exp.getMessage();
		long timeStamp = System.currentTimeMillis();
		ExceptionBody status = new ExceptionBody(HttpStatus.NOT_FOUND.value(), message, timeStamp);
		return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionBody> handleException(Exception exp)
	{
		String message = exp.getMessage();
		long timeStamp = System.currentTimeMillis();
		int httpStatus = HttpStatus.BAD_REQUEST.value();
		HttpStatus header = HttpStatus.BAD_REQUEST;
		ExceptionBody body = new ExceptionBody(httpStatus, message, timeStamp);
		return new ResponseEntity<>(body, header);
	}

}