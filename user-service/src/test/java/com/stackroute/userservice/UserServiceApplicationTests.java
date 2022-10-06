package com.stackroute.userservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.userservice.controller.RegistrationController;
import com.stackroute.userservice.serviceimpl.UserServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceApplicationTests {

	@Autowired
	private RegistrationController registrationController;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Test
	void contextLoads() {
		assertThat(registrationController).isNotNull();
		assertThat(userServiceImpl).isNotNull();
	}

}
