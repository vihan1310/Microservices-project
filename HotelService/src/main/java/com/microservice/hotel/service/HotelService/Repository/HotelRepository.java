package com.microservice.hotel.service.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.service.HotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
