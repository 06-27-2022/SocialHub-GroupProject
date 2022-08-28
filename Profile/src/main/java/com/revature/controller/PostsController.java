package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Posts;
import com.revature.service.PostsService;


@RestController("postsController")
@RequestMapping("/posts")
public class PostsController {
	@Autowired
	PostsService postsService;
	
	@GetMapping(path = "/all")
	public List<Posts> findAllPosts(){
		return this.postsService.findAllPosts();
		
	}
	
	
	@GetMapping(path = "/")
	public List<Posts> findByUserId(@RequestParam int userId){
		return this.postsService.findPostByUserId(userId);
		
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Posts posts) {
		this.postsService.save(posts);
	}
	
}
