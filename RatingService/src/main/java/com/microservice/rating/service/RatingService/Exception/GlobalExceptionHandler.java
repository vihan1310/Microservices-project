package com.microservice.rating.service.RatingService.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException rnfe){
		Map<String, Object> map=new HashMap<>();
		map.put("message", rnfe.getMessage());
		map.put("success", true);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	
		
	}
	
	

}
