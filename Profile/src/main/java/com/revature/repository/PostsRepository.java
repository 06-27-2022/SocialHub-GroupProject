package com.revature.repository;
import java.util.List;

import com.revature.model.Posts;

public interface PostsRepository {
	List<Posts> findAllByUserId(int id);
	List<Posts> findAllPosts();
	void save(Posts cPosts);
}

