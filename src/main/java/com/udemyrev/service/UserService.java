package com.udemyrev.service;

import java.util.List;

import com.udemyrev.DTO.userDto;
import com.udemyrev.entity.User;

public interface UserService {
	
	//User createUser(User user);
	userDto createUser(userDto user);
	User getUserById(Long userId);
	List<User> getAllUsers();
	void deleteUser(Long userid);
	User update(User user);
	
	
}
