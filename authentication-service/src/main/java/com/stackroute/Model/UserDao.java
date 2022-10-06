package com.stackroute.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserDao {
	
	@Id
	private String email;
	private String password;
	private UserRole userRole;


	public UserDao() {
		super();
	}
	public UserDao(String email, String password, UserRole userRole) {
		super();
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userEmail) {
		this.email = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
