package com.stackroute.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.Model.UserDao;
import com.stackroute.Repository.UserAuthenticationRepository;
import com.stackroute.Service.UserAuthenticationService;


@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private UserAuthenticationRepository userRepository;

	@Override
	public UserDao addUser(UserDao user) {

		return userRepository.save(user);
	}

	@Override
	public UserDao userValidation(String email, String password) throws Exception {
		if(userRepository.findByEmailAndPassword(email, password)==null)
		{
			throw new Exception();
		}
		return userRepository.findByEmailAndPassword(email, password);
	}

}
