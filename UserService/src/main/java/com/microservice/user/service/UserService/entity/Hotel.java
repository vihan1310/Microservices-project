package com.microservice.user.service.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	
	private Integer hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelAbout;

}
