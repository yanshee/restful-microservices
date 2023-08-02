package com.udemyrev.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.udemyrev.DTO.userDto;
import com.udemyrev.entity.User;
import com.udemyrev.exception.ErrorDeatils;
import com.udemyrev.exception.ResourceNotFound;
import com.udemyrev.service.UserService;
import lombok.AllArgsConstructor;

@RestController
//@AllArgsConstructor
public class userController {

	@Autowired
	private UserService userService;
	
	//create rest api for user using JPA entity method
//	@PostMapping("user")
//	public ResponseEntity<User>createUser(@RequestBody User user){
//		User savedUser=userService.createUser(user);
//		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
//	}
//	
	//create rest api for user using DTO  method
	
	@PostMapping("user/create")
	public ResponseEntity<userDto> createUser(@RequestBody userDto user){
		userDto savedUser=userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
	}
	

	//build getuserby id rest api
	//http://localhost:8080/user/id
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
		User userById=userService.getUserById(userId);
		return new ResponseEntity<>(userById,HttpStatus.CREATED);	
	}
	
	//using DTO 
//	public ResponseEntity<userDto> getUserById(@PathVariable("id") Long userId){
//		userDto user=userService.getUserById(userId);
//		return new ResponseEntity<>(userById,HttpStatus.CREATED);	
//	}
	
	//Get all users REST API
	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userAll=userService.getAllUsers();
		return new ResponseEntity<>(userAll,HttpStatus.CREATED);
	}
	
	//Delete user REST API
	@DeleteMapping("delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted Successfully!! ",HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<User> update(@PathVariable("id") Long userId, @RequestBody User user){
		user.setId(userId);
		User updateduser=userService.update(user);
		return new ResponseEntity<>(updateduser,HttpStatus.CREATED);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDeatils> handleResourceNotFound(ResourceNotFound exception,WebRequest webRequest){
		
		ErrorDeatils errorDetails=new ErrorDeatils(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
						"USER_NOT_FOUND"
				);
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
