package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Login;
import com.revature.repository.LoginRepository;

@Service("trainerService")
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public void save(Login login) {
		this.loginRepository.save(login);
	}
	
	public List<Login> findAll(){
		return this.loginRepository.findAll();
	}
}
