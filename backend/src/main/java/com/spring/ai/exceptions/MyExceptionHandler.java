package com.spring.ai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyExceptionHandler {
	
      @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> generalExcepiton( Exception e,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
      
      @ExceptionHandler(NoHandlerFoundException.class)
  	public ResponseEntity<ErrorDetails> noHandlerFoundExcepiton( NoHandlerFoundException e,WebRequest req){
  		ErrorDetails err= new ErrorDetails();
  		err.setTimestamp(LocalDateTime.now());
  		err.setMessage(e.getLocalizedMessage());
  		err.setDescription(req.getDescription(false));
  		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
  	}
	
}
