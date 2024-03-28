package com.microservice.rating.service.RatingService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Rating {
	@Id
	
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer ratingStar;
	
	private String feedback;
	

}
