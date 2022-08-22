package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	<S extends Login> S save(Login login);
	List<Login> findAll();
}
