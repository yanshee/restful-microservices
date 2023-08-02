package com.udemyrev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyrev.DTO.userDto;
import com.udemyrev.Mapper.UserMapper;
import com.udemyrev.entity.User;
import com.udemyrev.exception.ResourceNotFound;
import com.udemyrev.repository.UserRepository;
import com.udemyrev.service.UserService;
import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor  // constructor based dependency injection to create constructor for userrepository instance variable
 public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;  //inject userrepository in user service

//	@Override
//	public User createUser(User user) {
//		// TODO Auto-generated method stub
//		return userRepository.save(user);
//	}

	
//	@Override
//	public userDto createUser(userDto userdto) {
//		
//		convert userDto in user JPA entity in order to save data into DB
//		User user=new User(userdto.getId(), 
//				          userdto.getFirstname(),
//				          userdto.getLastname(),
//				          userdto.getEmail());
//		
//		User saveduser=userRepository.save(user);
//		
//		//convert user JPA entity to user DTO
//		userDto saveduserdto=new userDto(saveduser.getId(),
//										saveduser.getFirstname(),
//										saveduser.getLastname(),
//										saveduser.getEmail());
//		return saveduserdto;
//		
//	}
	
	
	//when we have created userMapper class in general for every method, 
	//no need to write this above code, we can directly call methods from userMapper class
	@Override
	public userDto createUser(userDto userdto) {
		
		//convert user into DTO
		User user=UserMapper.mapDtotoJpa(userdto);
		User savedUser=userRepository.save(user);
		
		//convert Dto in JPA
		userDto saveduserDto=UserMapper.mapJpatoDto(savedUser);
		
		return saveduserDto;
	}
	
	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser=userRepository.findById(userId);
		return optionalUser.get();
	}
	
	
	@Override 
	public List<User> getAllUsers(){
		return userRepository.findAll();	
	}
	
//	@Override
//	public void deleteUser(Long userId) {
//		userRepository.deleteById(userId);
//	}
	
	//code to handle custom exception when user trying to delete a non-existing person
	@Override
	public void deleteUser(Long userId) {
		User existUser=userRepository.findById(userId).orElseThrow(
				() ->new ResourceNotFound("User","id",userId)
				);
		
		userRepository.deleteById(userId);
	}
	
	@Override
	public User update(User user) {
		User existUser=userRepository.findById(user.getId()).get();
		existUser.setFirstname(user.getFirstname());
		existUser.setLastname(user.getLastname());
		existUser.setEmail(user.getEmail());
		User updateUser=userRepository.save(existUser);
		return updateUser;
	}

}
