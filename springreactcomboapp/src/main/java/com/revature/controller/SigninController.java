package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Signin;
import com.revature.service.RegisterService;
import com.revature.service.SigninService;

@RestController("signinController")
@RequestMapping("/")
public class SigninController {

	@Autowired
	private SigninService signinService;
	
	@PostMapping("/sign-in")
	public void save(@RequestBody Signin signin) {
		this.signinService.save(signin);
	}
	
	@GetMapping("/allsignin")
	public List<Signin> findAll(){
		return this.signinService.findAll();
	}
}
