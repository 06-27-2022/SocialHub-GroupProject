//package com.revature.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.model.Register;
//import com.revature.service.RegisterService;
//
//@RestController("registerController")
//@RequestMapping("/")
//public class RegisterController {
//
//	@Autowired
//	private RegisterService registerService;
//	
//	@PostMapping("/register")
//	public void save(@RequestBody Register register) {
//		this.registerService.save(register);
//	}
//	
//	@GetMapping("/all")
//	public List<Register> findAll(){
//		return this.registerService.findAll();
//	}
//}
