 package com.microservice.rating.service.RatingService.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.service.RatingService.Entity.Rating;
import com.microservice.rating.service.RatingService.Exception.ResourceNotFoundException;
import com.microservice.rating.service.RatingService.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		Integer randomUUID = UUID.randomUUID().hashCode();
		rating.setRatingId(randomUUID);
		
		return ratingRepository.save(rating) ;
	}

//	@Override
//	public Rating getRatingById(Integer ratingId) {
//		
//		return ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException());
//	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		////if(ratingRepository.existsById(hotelId))
		return ratingRepository.findByHotelId(hotelId);
		//else {
		//	return (List<Rating>) new ResourceNotFoundException("hotel with given id is not found ,,change the id");
		}
	}


