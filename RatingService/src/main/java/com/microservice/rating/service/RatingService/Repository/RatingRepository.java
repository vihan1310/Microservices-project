package com.microservice.rating.service.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.rating.service.RatingService.Entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	List<Rating> findByUserId(Integer userId);
	List<Rating> findByHotelId(Integer hotelId);
	

}
