package com.demowar.riverstone.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHAndler extends ResponseEntityExceptionHandler {
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public final ResponseEntity handleValidationException(
//			MethodArgumentNotValidException ex, WebRequest request) {
//		 	Map<String, String> errors = new HashMap<>();
//		    ex.getBindingResult().getAllErrors().forEach((error) -> {
//		        String fieldName = ((FieldError) error).getField();
//		        String errorMessage = error.getDefaultMessage();
//		        errors.put(fieldName, errorMessage);
//		    });
////		    ErrorDetails errorDetails =
////		        new ErrorDetails(ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		    return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
//		  }
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,String> errors = new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});
		ErrorResponse errorDetails =
		        new ErrorResponse(errors, request.getDescription(false), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGlobalException(
	      Exception ex, WebRequest request) {
	    
		ErrorResponse errorDetails =
	        new ErrorResponse(ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.toString());
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
