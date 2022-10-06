package com.stackroute.userservice.dto;

public class UserDTOPublisher {

	
	private String userEmail;
	private String password;
	private UserRole userRole;

	public UserDTOPublisher(String userEmail, String password, UserRole userRole) {
		super();
		this.userEmail = userEmail;
		this.password = password;
		this.userRole = userRole;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTOPublisher() {
		super();
	}

}
