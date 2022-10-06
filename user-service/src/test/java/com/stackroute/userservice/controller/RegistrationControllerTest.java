package com.stackroute.userservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.dto.UserDto;
import com.stackroute.userservice.modal.ERole;
import com.stackroute.userservice.modal.User;
import com.stackroute.userservice.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

	@Mock
	private UserServiceImpl userServiceImpl;

	@InjectMocks
	private RegistrationController registrationController;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	}

	@AfterEach
	void clean() {
		mockMvc = null;
	}

	private String jsontoString(final Object obj) {
		String result;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonContent = objectMapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException ex) {
			result = "error while converting to string";
		}
		return result;
	}

	@Test
	void createAccountTest() throws Exception {
		String uri = "/api/brainzo/v1/signup";
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId("abc.xyz@gmail.com");
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		String inputJson = jsontoString(userDto);
		System.err.println(inputJson);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, " Account with " + userDto.getEmailId() + " created successfully ");
	}

	@Test
	void getAccountDetailsTest() throws Exception {
		String email = "abc.xyz@gmail.com";
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId(email);
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		String inputJson = jsontoString(userDto);
		System.err.println(inputJson);
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		lenient().when(userServiceImpl.getUserByDetails(email)).thenReturn(user);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/brainzo/v1/{emailId}", email)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		assertEquals(user, userServiceImpl.getUserByDetails(email));
	}

	@Test
	void updateUserNameTest() throws Exception {
		String email = "abc.xyz@gmail.com";
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId(email);
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		String inputJson = jsontoString(userDto);
		System.err.println(inputJson);
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		lenient().when(userServiceImpl.updateUserName(email, userDto)).thenReturn(user);

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.put("/api/brainzo/v1/update-username/{emailId}", email)
						.contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		assertEquals(user, userServiceImpl.updateUserName(email, userDto));
	}

	@Test
	void updatePhoneNumberTest() throws Exception {
		String email = "abc.xyz@gmail.com";
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId(email);
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		String inputJson = jsontoString(userDto);
		System.err.println(inputJson);
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		lenient().when(userServiceImpl.updateUserName(email, userDto)).thenReturn(user);

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.put("/api/brainzo/v1/update-mobile/{emailId}", email)
						.contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	void updateCityTest() throws Exception {
		String email = "abc.xyz@gmail.com";
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId(email);
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		String inputJson = jsontoString(userDto);
		System.err.println(inputJson);
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		lenient().when(userServiceImpl.updateUserName(email, userDto)).thenReturn(user);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/brainzo/v1/update-city/{emailId}", email)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
