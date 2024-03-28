package com.microservice.hotel.service.HotelService.Services;

import java.util.List;

import com.microservice.hotel.service.HotelService.Entity.Hotel;


public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	Hotel getHotelById(Integer hotelId);
	
	List<Hotel> getAllHotel();

}
