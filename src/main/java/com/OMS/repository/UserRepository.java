package com.OMS.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OMS.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	User findByUserName(String userName);
	User save(User addressDetails);
	

}
