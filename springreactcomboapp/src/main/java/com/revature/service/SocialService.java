package com.revature.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Social;
import com.revature.repository.SocialRepository;

/*
 * @Service is a Spring stereotype that indicates that the annotated type should be added to the
 * container as a Spring bean.
 * 
 * @Service should be used for classes that contain business logic.
 * 
 * Also note that there is a generic stereotype called @Component. In fact, all specialized stereotypes
 * are built on top of @Component.
 */

@Service("socialService")
public class SocialService {

	/*
	 * We can identify this as a dependency of this class; it is not possible for the SocialService
	 * to access the data source without having a PolkamanRepositoryImpl object.
	 */
	@Autowired
	private SocialRepository socialRepository;
	
	/*
	 * Spring looks for this no-args constructor when wiring in beans unless you're using 
	 * constructor injection.
	 */
	public SocialService() {
		
	}
	
	/*
	 * You can also instruct Spring to use constructor injection to perform dependency injection.
	 * 
	 * Note that by using @Autowired, we're instructing Spring to use the construction to wire in
	 * our dependencies.
	 */
//	@Autowired
//	public SocialService(SocialRepository socialRepository) {
//		this.polkamanRepository = socialRepository;
//	}
	
	/*
	 * By default, Spring uses setter injection. This means that when it attempts to perform dependency
	 * injection (DI) for us, it attempts to call a setter method in which it passes the bean to us.
	 * 
	 * Spring is very much about "convention over configuration". It expects you to name methods in
	 * very conventional ways. For instance, this setter needs to follow the convention for setters as
	 * far as naming goes (set + propertyName).
	 */
//	@Autowired
//	public void setPolkamanRepository(SocialRepository socialRepository) {
//		this.polkamanRepository = socialRepository;
//	}
	

	public List<Social> findAllByOrderBySocialname(){
		
		return this.socialRepository.findAllByOrderBySocialname();
	}
	
	public Social findById(int id) {
		return this.socialRepository.findById(id);
	}
	
	public void save(Social social) {
		this.socialRepository.save(social);
	}
	
	public List<Social> findAllBySocialType(String socialType){
		return this.socialRepository.findAllBySocialtype(socialType);
	}
}
