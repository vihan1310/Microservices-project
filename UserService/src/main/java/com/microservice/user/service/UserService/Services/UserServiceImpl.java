package com.microservice.user.service.UserService.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.microservice.user.service.UserService.FeignClient.HotelService;
import com.microservice.user.service.UserService.FeignClient.RatingService;
import com.microservice.user.service.UserService.Repository.UserRepository;
import com.microservice.user.service.UserService.entity.Hotel;
import com.microservice.user.service.UserService.entity.Rating;
import com.microservice.user.service.UserService.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService; //for feign client use.
	
	@Autowired
	private RatingService ratingService; //for feign client.

	@Override
	public User saveUser(User user) {
		Integer randomUUID = UUID.randomUUID().hashCode();
		user.setUserId(randomUUID);
		userRepository.save(user);
		return user;
	}

//	@Override
//	public User getUserById(Integer userId) {
//		
//		 User user = userRepository.findById(userId).orElseThrow(()->
//		new ResourceNotFoundException("user with given id is not found on the server :"+userId));
//		 
//		 //fetching the rating given by the above user from Rating service(calling different microservice)
////		 Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/byuserId/"+userId, Rating[].class);
//		 Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/byuserId/"+userId, Rating[].class); //to remove host and port dependency
//		 List<Rating> ratingList = Arrays.stream(ratingsOfUser).toList(); //converting Rating[] to list<Rating>
//	
//		 
//		 List<Rating> finalRatingList = ratingList.stream().map(rating->{
////			 ResponseEntity<Hotel> forHotel = restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
//			 ResponseEntity<Hotel> forHotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class); 
//			 //need to add @LoadBalancer to balance out the load and mark them to use name instead of host and port.
//			
//			 Hotel hotel = forHotel.getBody();
//			 rating.setHotel(hotel);
//			 return rating;
//		 }).collect(Collectors.toList());
//		 
//		 
//		 
//		 user.setRatings(finalRatingList);
//		 
//		 
//		return user;
//		
//	}
//	
	               //Using feign client.
	@Override
	public User getUserById(Integer userId) {
		
		 User user = userRepository.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("user with given id is not found on the server :"+userId));
		 
	
		 List<Rating> user2 = ratingService.getAllRatingUser(userId);
		 
		 List<Rating> finalRatingList = user2.stream().map(rating->{
			
			 Hotel hotel = hotelService.getHotel(rating.getHotelId());
			 rating.setHotel(hotel);
			 return rating;
		 }).collect(Collectors.toList());
		 
		 
		 
		 user.setRatings(finalRatingList);
		 
		 
		return user;
		
	}


	@Override
	public List<User> getAllUser() {
		List<User> userAllList= userRepository.findAll();
		List<User> finalUsers = userAllList.stream().map(user1->{
			List<Rating> allRatingUser = ratingService.getAllRatingUser(user1.getUserId());
			List<Rating> collectedRating = allRatingUser.stream().map(rating->{
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			user1.setRatings(collectedRating);
			return user1;
		}).collect(Collectors.toList());
		
		
		return finalUsers;
	}

}
