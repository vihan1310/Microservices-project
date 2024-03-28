package com.microservice.user.service.UserService.Services;

import java.util.List;

import com.microservice.user.service.UserService.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	User getUserById(Integer userId);
	
	List<User> getAllUser();

}
