package com.stackroute.Model;

public class AuthRequest {

    private String email;
    private String password;
    private UserRole userRole;
    
	public AuthRequest(String email, String password, UserRole userRole) {
		super();
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	
	public AuthRequest() {
		super();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
    
}