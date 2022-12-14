package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
}
