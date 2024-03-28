package com.microservice.hotel.service.HotelService.Controller;

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

import com.microservice.hotel.service.HotelService.Entity.Hotel;
import com.microservice.hotel.service.HotelService.Services.HotelService;



@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		 Hotel hotel1 = hotelService.saveHotel(hotel);
		 return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable Integer hotelId){
		Hotel hotel2 = hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotel2);
		
		
	}
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel2 = hotelService.getAllHotel();
		return ResponseEntity.ok(hotel2);
	}
}
