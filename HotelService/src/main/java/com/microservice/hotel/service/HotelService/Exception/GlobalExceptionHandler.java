package com.microservice.hotel.service.HotelService.Exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.NotFound;
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
