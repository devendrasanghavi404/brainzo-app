package com.stackroute.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.dto.UserDto;
import com.stackroute.userservice.modal.User;
import com.stackroute.userservice.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/brainzo/v1")
public class RegistrationController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping(value = "/signup")
	ResponseEntity<String> createAccount(@RequestBody UserDto userDto) {
		userServiceImpl.registerUser(userDto);
		return new ResponseEntity<>(" Account with " + userDto.getEmailId() + " created successfully ", HttpStatus.OK);
	}

	@GetMapping(value = "/{emailId}")
	ResponseEntity<User> getUserDetails(@PathVariable String emailId) {
		User userByDetails = userServiceImpl.getUserByDetails(emailId);
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

	@PutMapping(value = "update-username/{emailId}")
	ResponseEntity<User> updateUserNameByEmailId(@PathVariable String emailId, @RequestBody UserDto userDto) {
		User userByDetails = userServiceImpl.updateUserName(emailId, userDto);
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

	@PutMapping(value = "update-mobile/{emailId}")
	ResponseEntity<User> updateMobileNumberEmailById(@PathVariable String emailId, @RequestBody UserDto userDto) {
		User userByDetails = userServiceImpl.updateMobileNumber(emailId, userDto.getMobileNumber());
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

	@PutMapping(value = "update-city/{emailId}")
	ResponseEntity<User> updateCityByEmailId(@PathVariable String emailId, @RequestBody UserDto userDto) {
		User userByDetails = userServiceImpl.updateCity(emailId, userDto.getCity());
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

	@PutMapping(value = "update-state/{emailId}")
	ResponseEntity<User> updateStateByEmailId(@PathVariable String emailId, @RequestBody UserDto userDto) {
		User userByDetails = userServiceImpl.updateState(emailId, userDto.getState());
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

	@PutMapping(value = "update-country/{emailId}")
	ResponseEntity<User> updateCountryByEmailId(@PathVariable String emailId, @RequestBody UserDto userDto) {
		User userByDetails = userServiceImpl.updateCountry(emailId, userDto.getCountry());
		return new ResponseEntity<>(userByDetails, HttpStatus.OK);

	}

}
