package com.stackroute.userConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stackroute.Model.UserDTOPublisher;
import com.stackroute.Model.UserDao;
import com.stackroute.serviceImpl.UserAuthenticationServiceImpl;

@Component
public class Consumer {
	@Autowired
	private UserAuthenticationServiceImpl userService;

	  @RabbitListener(queues = "user_service_queue") 
	  public void getUserDtoFromRabbitMq(UserDTOPublisher userDto) {
	    System.out.println(userDto.toString());
	    UserDao users = new UserDao();
	    users.setEmail(userDto.getUserEmail());
	    users.setPassword(userDto.getPassword());
	    users.setUserRole(userDto.getUserRole());
	     userService.addUser(users); 
	 }
	 
}
