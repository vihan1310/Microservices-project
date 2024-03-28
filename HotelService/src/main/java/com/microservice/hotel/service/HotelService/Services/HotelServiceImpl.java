package com.microservice.hotel.service.HotelService.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.service.HotelService.Entity.Hotel;
import com.microservice.hotel.service.HotelService.Exception.ResourceNotFoundException;
import com.microservice.hotel.service.HotelService.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		Integer randomUUID = UUID.randomUUID().hashCode();
		hotel.setHotelId(randomUUID);
		
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		
		return hotelRepository.findById(hotelId).
				orElseThrow(()->new ResourceNotFoundException("hotel not found with the given id"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}

}
