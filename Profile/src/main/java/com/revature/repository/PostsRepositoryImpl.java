package com.revature.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.revature.model.Posts;

@Repository("postsRepository")
public class PostsRepositoryImpl implements PostsRepository{
	private static List<Posts> postsList;
	
	public static void initPolkamans() {
		postsList = new ArrayList<>();
		postsList.add(new Posts(1,1,"Text"));
		postsList.add(new Posts(1,2,"Another Text"));
		postsList.add(new Posts(1,1,"Another one"));
		postsList.add(new Posts(1,2,"Text 4"));
		postsList.add(new Posts(1,1,"a;lskdjf;l"));
	}
	
	static {
		initPolkamans();
	}

	@Override
	public List<Posts> findAllByUserId(int id){
		List<Posts> postsArray = new ArrayList<>();
		for(Posts cPosts : postsList) {
			if(cPosts.getMakerId() == id) {
				postsArray.add(cPosts);
			}
		}
		return postsArray;
	}

	@Override
	public void save(Posts posts) {
		postsList.add(posts);
		
	}

}


