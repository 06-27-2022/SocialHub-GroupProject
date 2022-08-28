package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Signin;


public interface SigninRepository extends JpaRepository<Signin, Integer>{

	<S extends Signin> S save(Signin signin);
	List<Signin> findAll();
}
