package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

@Table(name = "login")
public class Login {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "login_name")
	private String login_name;
	@Column(name = "password")
	private String password;
/*
 * Collection of social parameters
 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private Set<Social> socials;
}
