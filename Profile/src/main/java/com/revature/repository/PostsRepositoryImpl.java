package com.revature.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Posts;

@Repository("postsRepository")
@Transactional
public class PostsRepositoryImpl implements PostsRepository{
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public List<Posts> findAllByUserId(int id){
//		return this.jdbcTemplate
//				.query("select * from posts", new DataClassRowMapper<Posts>(Posts.class));
		return this.entityManager.createQuery("FROM Posts where makerId ="+id, Posts.class).getResultList();
	}

	@Override
	public List<Posts> findAllPosts() {
//		return this.jdbcTemplate
//				.query("select * from posts", new DataClassRowMapper<Posts>(Posts.class));
		return this.entityManager.createQuery("FROM Posts", Posts.class).getResultList();
	}
	
	
	@Override
	public void save(Posts posts) {
//		this.jdbcTemplate.update("insert into posts values (default, ?,?)", 
//				posts.getMakerId(),posts.getPostText());
		this.entityManager.persist(posts);
	}

}


