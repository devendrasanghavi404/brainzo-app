package com.stackroute.chatservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.chatservice.controller.ChatOpenForumController;
import com.stackroute.chatservice.serviceimpl.ChatOpenForumServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class QnaServiceApplicationTests {

	@Autowired
	private ChatOpenForumController chatOpenForumController;

	@Autowired
	private ChatOpenForumServiceImpl chatOpenForumServiceImpl;

	@Test
	void contextLoads() {
		assertThat(chatOpenForumController).isNotNull();
		assertThat(chatOpenForumServiceImpl).isNotNull();
	}

}
