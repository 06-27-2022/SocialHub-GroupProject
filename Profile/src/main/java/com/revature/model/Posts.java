package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name ="posts")
public class Posts {
	@Id
	@Column(name ="id")

	@GeneratedValue(generator = "posts_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize=1,name="posts_id_seq")
	private int id;
	
	@Column(name ="postText")
	private String postText;
	
	@ManyToOne
	@JoinColumn(name = "users")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Posts(int id, String postText, User user) {
		super();
		this.id = id;
		this.postText = postText;
		this.user = user;
	}

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Column(name ="makerId")
//	private int makerId;
//
//	public int getMakerId() {
//		return makerId;
//	}
//
//	public void setMakerId(int makerId) {
//		this.makerId = makerId;
//	}
	
	

}
