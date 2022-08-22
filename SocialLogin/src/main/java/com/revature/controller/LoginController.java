package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Login;
import com.revature.service.LoginService;

@RestController("loginController")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/new")
	public void save(@RequestBody Login login) {
		this.loginService.save(login);
	}
	
	@GetMapping("/all")
	public List<Login> findAll(){
		return this.loginService.findAll();
	}
}
