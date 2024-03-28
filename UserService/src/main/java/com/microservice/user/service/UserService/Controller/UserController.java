package com.microservice.user.service.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.service.UserService.Services.UserService;
import com.microservice.user.service.UserService.entity.User;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "breakerRatingHotel", fallbackMethod = "ratingHotelFallBack")
   // @Retry(name = "retryRatingHotel",fallbackMethod = "ratingHotelFallBack")
	//@RateLimiter(name = "rateLimiterRatingHotel", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){
		User user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	//fallbck method for circuit breaker ,,,agr service down hui to ye method chlega.(return type ,parameter same hona chahiye as of that 
	// method jaaha dependency Aarhi hi.)
	//int retryCount=1;
	public ResponseEntity<User> ratingHotelFallBack(Integer userId,Exception ex){
		//System.out.println("retry count"+retryCount);
		//retryCount++;
		User user=User.builder().userId(101).userName("fall back method").userAbout("dummy user").userEmail("dummy@user").build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
