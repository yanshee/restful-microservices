package com.udemyrev.Mapper;

import com.udemyrev.DTO.userDto;
import com.udemyrev.entity.User;

public class UserMapper {
	
	
	//convert user JPA Entity to user DTO
	public static userDto mapJpatoDto(User user) {
		userDto userdto=new userDto(user.getId(),
									user.getFirstname(),
									user.getFirstname(),
									user.getEmail());
		
		return userdto;
	}
	
	public static User mapDtotoJpa(userDto userdto) {
		User user1=new User(userdto.getId(),
							  userdto.getFirstname(),
							  userdto.getLastname(),
							  userdto.getEmail());
		return user1;
	}
}
