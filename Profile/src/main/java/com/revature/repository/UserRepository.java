package com.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository("userRepository")
@Transactional
public class UserRepository {
	
	@PersistenceContext( type= PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public void save(User user) {
		this.entityManager.persist(user);
	}
	
	public List<User> findAll(){
		return this.entityManager.createQuery("FROM User", User.class).getResultList();
	}
}
