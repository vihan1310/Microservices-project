package com.microservice.rating.service.RatingService.Service;

import java.util.List;

import com.microservice.rating.service.RatingService.Entity.Rating;

public interface RatingService {
	
	Rating saveRating(Rating rating);
	
	//Rating getRatingById(Integer ratingId);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(Integer userId);
	
	List<Rating> getRatingByHotelId(Integer hotelId);

}
