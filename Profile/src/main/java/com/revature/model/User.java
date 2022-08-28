package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "userId")
	private int userId;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "region")
	private String region;
	
}
