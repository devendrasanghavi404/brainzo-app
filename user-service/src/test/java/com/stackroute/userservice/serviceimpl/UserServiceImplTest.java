package com.stackroute.userservice.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.userservice.dto.UserDto;
import com.stackroute.userservice.exception.UserIsNotPresentException;
import com.stackroute.userservice.modal.ERole;
import com.stackroute.userservice.modal.User;
import com.stackroute.userservice.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@Autowired
	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	void testRegisterUser() {
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
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		assertThat(user.getEmailId()).isSameAs(userDto.getEmailId());

	}

	@Test
	void testGetUserByDetails() {
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
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmailId(),
				userDto.getMobileNumber(), userDto.getCity(), userDto.getState(), userDto.getCountry(),
				userDto.getPassword());
		when(userRepository.findById(user.getEmailId())).thenReturn(Optional.of(user));
		assertEquals(userServiceImpl.getUserByDetails(userDto.getEmailId()),
				userRepository.findById(userDto.getEmailId()).get());
	}

	@Test
	void testUpdateUserName() {
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");
		userDto.setLastName("xyz");
		userDto.setEmailId("dhirendra.singh1@gmail.com");
		userDto.setMobileNumber("9012232323");
		userDto.setCity("Sector52");
		userDto.setState("UP");
		userDto.setCountry("India");
		userDto.setRole(ERole.LEARNER);
		userDto.setPassword("abcdefghi");
		UserIsNotPresentException userIsNotPresentException = assertThrows(UserIsNotPresentException.class,
				() -> userServiceImpl.updateUserName("dhirendra.singh1@gmail.com", userDto));
		assertEquals("User Details is not present", userIsNotPresentException.getMessage());
	}

}
