package com.stackroute.userservice.service;

import com.stackroute.userservice.dto.UserDto;
import com.stackroute.userservice.modal.User;

public interface UserService {

	String registerUser(UserDto user);

	User getUserByDetails(String emailId);

	User updateUserName(String emailId, UserDto userDto);

	User updateMobileNumber(String emailId, String mobileNumber);

	User updateCity(String emailId, String city);

	User updateState(String emailId, String state);

	User updateCountry(String emailId, String country);

}
