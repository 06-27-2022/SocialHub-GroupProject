package com.revature.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Register;
import com.revature.service.RegisterService;


@RestController
public class SocialHubController {
	
    @GetMapping("/api/socialhub")
    public String socialHub() {
        return "This is a Profile Page. You can create a profile here.";
    }
    @Autowired
    private RegisterService registerService;
    
    @PostMapping("/register")
	public void save(@RequestBody Register register) {
		this.registerService.save(register);
		
	}
    
    

    
    
	@GetMapping("/all")
	public List<Register> findAll(){
	return this.registerService.findAll();
	}
//    @GetMapping("/api/socialhubgroups")
//    public String socialHubGroup() {
//        return "This is a Group Page. You can join a group here.";
//    }
}