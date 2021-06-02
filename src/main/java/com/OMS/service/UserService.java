package com.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OMS.model.User;
import com.OMS.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	

	public User createUserData(User userRequest) {
		List<User> findData = userRepository.findAll();
		System.out.println("customer Data" + findData);
		for (User user : findData) {
			if (userRequest.getEmailId().equals(user.getEmailId())) {
				System.out.println("Already exists the Id");
				return user;
			}
		}
		return userRepository.save(userRequest);
	}
	public List<User> findAllList() {
		return userRepository.findAll();
	}
}
