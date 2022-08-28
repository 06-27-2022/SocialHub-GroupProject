package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer>{

	<S extends Register> S save(Register register);
	List<Register> findAll();
}
