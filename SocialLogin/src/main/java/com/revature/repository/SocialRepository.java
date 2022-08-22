package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Social;

/*
 * Typically when you're building a Spring Boot project, you use a module called "Spring Data JPA"
 * with it. Spring Data JPA is a module of Spring that can abstract away repository implementations
 * from developers.
 * 
 * But where will the implementation come from if we only have interfaces?
 * 
 * Spring Data JPA is capable of providing these implementations at runtime. All you have to do is
 * provide interfaces that extend either the JpaRepository or the CrudRepository (the sources of
 * many of the common methods that Spring Data Jpa implements at runtime).
 * 
 * When extending the JpaRepository, the first generic should be the type of the entity and the
 * second generic should be the type of the entity's unique identifier (primary key).
 */

public interface SocialRepository extends JpaRepository<Social, Integer>{

	/*
	 * Sometimes, we are limited in what we can do with the JPA expression language. In those cases,
	 * we might want to be able to do slightly modify the query that will be executed by Spring
	 * Data JPA. In order to do so, we can use the @Query annotation.
	 */
	@Query("select p from Social p where p.socialtype = ?1")
	List<Social> findBySocialtype(String socialtype);
	List<Social> findAllByOrderBySocialname();

	List<Social> findAllBySocialtype(String socialType);

	<S extends Social> S save(S entity);
	void delete(Social entity);
	Social findById(int id);
	
}
