package com.stackroute.Service;

import com.stackroute.Model.UserDao;

public interface UserAuthenticationService {

	public UserDao addUser(UserDao user);
	public UserDao userValidation(String email,String password) throws Exception;
}