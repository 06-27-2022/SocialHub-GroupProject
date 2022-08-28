package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Register;
import com.revature.repository.RegisterRepository;

@Service("registerService")
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	public void save(Register register) {
		this.registerRepository.save(register);
	}
	
	public List<Register> findAll(){
		return this.registerRepository.findAll();
	}
}
