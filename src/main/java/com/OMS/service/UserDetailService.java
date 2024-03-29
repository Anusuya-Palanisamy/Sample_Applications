package com.OMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OMS.model.User;
import com.OMS.model.UserDetailsImpl;
import com.OMS.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUserName(username);
		System.out.println("inside impl " + user);

		if (user == null) {
			System.out.println("exception thrown");
			throw new UsernameNotFoundException(username + "not found");
		}
		return new UserDetailsImpl(user);
	}

}