package com.stackroute.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.userservice.modal.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Boolean existsByEmailId(String emailId);
	
	

}
