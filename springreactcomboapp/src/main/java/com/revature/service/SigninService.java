package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Signin;
import com.revature.repository.SigninRepository;

@Service("signinService")
public class SigninService {

	@Autowired
	private SigninRepository signinRepository;
	
	public void save(Signin signin) {
		this.signinRepository.save(signin);
	}
	
	public List<Signin> findAll(){
		return this.signinRepository.findAll();
	}
}