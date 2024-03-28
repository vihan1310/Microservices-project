package com.microservice.rating.service.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.service.RatingService.Entity.Rating;
import com.microservice.rating.service.RatingService.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;	
	
	@PostMapping()
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		
		Rating rating1 = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	
//	@GetMapping("/{ratingId}")
//	public ResponseEntity<Rating> getSingleRating(@PathVariable Integer ratingId){
//		Rating rating2 = ratingService.getRatingById(ratingId);
//		return ResponseEntity.ok(rating2);
//	}
	
	@GetMapping()
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allRating = ratingService.getAllRating();
		return ResponseEntity.ok(allRating);
	}
	
	@GetMapping("/byuserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId){
		List<Rating> allRating = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(allRating);
	}
	
	@GetMapping("/byhotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer hotelId){
		List<Rating> allRating = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(allRating);
	}
	

}
