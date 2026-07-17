package com.vcube.hospitalmanagementapp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleresourceNotFoundException(ResourceNotFoundException ex){
		Map<String,Object> map = new HashMap<>();
		map.put("timestamp", LocalDateTime.now()); 
		map.put("Status", HttpStatus.NOT_FOUND.value());
		map.put("error",HttpStatus.NOT_FOUND.name());
		map.put("message", ex.getMessage());
		
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)

	public ResponseEntity<Map<String,Object>> handleGenericException(Exception ex){
		Map<String,Object> map = new HashMap<>();
		map.put("timestamp", LocalDateTime.now());
		map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		map.put("error", "INTERNAL_ERROR");
		map.put("message", ex.getMessage());
		
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	

}
