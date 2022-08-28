package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/new")
	public void save(@RequestBody User user) {
		this.userService.save(user);
	}
	
	@GetMapping("/all")
	public List<User> findAll(){
		return this.userService.findAll();
	}
}