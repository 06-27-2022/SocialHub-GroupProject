package com.revature.repository;
import java.util.List;

import com.revature.model.Posts;

public interface PostsRepository {
	List<Posts> findAllByUserId(int id);
	void save(Posts cPosts);
}

