package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Posts;
import com.revature.repository.PostsRepository;

@Service("postsService")
public class PostsService {
	
	@Autowired
	private PostsRepository postsRepository;
	
	public PostsService() {
		
	}
	public List<Posts> findAllPosts(){
		List<Posts> posts = this.postsRepository.findAllPosts();
		
		return posts;
	}
	public List<Posts> findPostByUserId(int i){
		List<Posts> posts = this.postsRepository.findAllByUserId(i);
		
		return posts;
	}
	
	public void save(Posts posts) {
		this.postsRepository.save(posts);
	}
}
