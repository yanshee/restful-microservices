package com.udemyrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemyrev.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> //TYPE OF ENTITY,type of primary key
{

	

}
