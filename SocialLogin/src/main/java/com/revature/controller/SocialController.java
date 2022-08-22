package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Social;
import com.revature.service.SocialService;


@RestController("socialController")
/*
 * If a client wants access to resources exposed by this controller,
 * they should use the following URL: /api/social/*
 */
@RequestMapping(path = "/social")
public class SocialController {
	
	@Autowired
	private SocialService socialService;
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * Let's start by adding a simple endpoint ("/all") that will allow the client to retrieve
	 * all Social parameters.
	 */
//	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	/*
	 * If you want a method's return value written to the HTTP response body, use the @Responsebody
	 * annotation.
	 */
//	@ResponseBody
	/*
	 * This annotation is a shortcut for @RequestMapping(method=RequestMethod.GET)
	 */
	@GetMapping(path = "/all")
	public List<Social> findAllByOrderBySocialname(){
		return this.socialService.findAllByOrderBySocialname();
	}
	
	/*
	 * Let's create an endpoint that allows us to find a Social parameter by its id.
	 * 
	 * Using a PathVariable, we can tell Spring to parse the request URL for us, isolating
	 * the "id" parameter and passing it to our method for us.
	 * 
	 * Using a ResponseEntity allows you a bit more control over the Http Response status code.
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Social> findById(@PathVariable int id) {
		return new ResponseEntity<Social>(this.socialService.findById(id), HttpStatus.OK);
	}
	
	/*
	 * For those of you who like allowing the client to send request parameters (e.g. the people
	 * who liked using request.getParameter with Servlets), you might enjoy using the @RequestParam
	 * annotation.
	 */
	@GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Social findByIdRequestParam(@RequestParam int id) {
		return this.socialService.findById(id);
	}
	
	
	/*
	 * Let's create an endpoint that allows us to add a new Social parameter to our existing group of
	 * Socials.
	 * 
	 * The @RequestBody annotation reads data from the Http request body and marshalls it as
	 * a Java object of the parameter type.
	 */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Social social) {
		this.socialService.save(social);
	}
	
	@GetMapping(path = "/socialtype/{socialType}")
	public List<Social> findAllBySocialType(@PathVariable String socialType){
		return this.socialService.findAllBySocialType(socialType);
	}
	
	/*
	 * This endpoint simply makes a HTTP request to the social api and then takes whatever data
	 * it receives in the HTTP response body and writes it to the response body that our application
	 * is sending to our client.
	 * 
	 * In other words:
	 * 
	 * 1) My frontend is a client to my Spring application
	 * 2) My Spring application is a client to the Social API
	 */
	@GetMapping(path = "/social-api/{name}")
	public Object findSocialApiSocialByName(@PathVariable String name) {
		return this.restTemplate.getForObject("social/" + name, Object.class);
	}
	

}
