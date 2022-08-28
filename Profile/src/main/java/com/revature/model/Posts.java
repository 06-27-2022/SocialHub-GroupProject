package com.revature.model;

import java.util.Objects;

public class Posts {
	private int id;
	private int makerId;
	private String postText;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMakerId() {
		return makerId;
	}

	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, makerId, postText);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posts other = (Posts) obj;
		return id == other.id && makerId == other.makerId && Objects.equals(postText, other.postText);
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", makerId=" + makerId + ", postText=" + postText + "]";
	}

	public Posts() {
		
	}
	public Posts(int id, int makerId, String postText) {
		super();
		this.id = id;
		this.makerId = makerId;
		this.postText = postText;
	}

}
