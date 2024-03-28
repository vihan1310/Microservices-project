package com.microservice.user.service.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating { 
	
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer ratingStar;
	
	private String feedback;
	
	private Hotel hotel;

}

