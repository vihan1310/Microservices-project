package com.microservice.hotel.service.HotelService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Hotel {
	
	@Id
	
	private Integer hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelAbout;
	
	

}
