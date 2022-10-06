package com.stackroute.userservice.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.dto.UserDTOPublisher;
import com.stackroute.userservice.dto.UserDto;
import com.stackroute.userservice.dto.UserRole;
import com.stackroute.userservice.exception.EmailAlreadyExistsException;
import com.stackroute.userservice.exception.InValidEmailException;
import com.stackroute.userservice.exception.UserIsNotPresentException;
import com.stackroute.userservice.modal.ERole;
import com.stackroute.userservice.modal.User;
import com.stackroute.userservice.publisher.UserProducer;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private static final String errorMessage = "User Details is not present";

	@Autowired
	private UserProducer producer;

	@Autowired
	private UserRepository userRepository;

	@Override
	public String registerUser(UserDto userDto) {
		User registratingUser = validateUserDetails(userDto);
		registratingUser.setFirstName(userDto.getFirstName());
		registratingUser.setLastName(userDto.getLastName());
		UserDTOPublisher dtoPublisher = new UserDTOPublisher();
		dtoPublisher.setPassword(userDto.getPassword());
		dtoPublisher.setUserEmail(userDto.getEmailId());
		if (userDto.getRole().toString().equals(ERole.LEARNER.toString()))
			dtoPublisher.setUserRole(UserRole.LEARNER);
		else if (userDto.getRole().toString().equals(ERole.MENTOR.toString()))
			dtoPublisher.setUserRole(UserRole.MENTOR);
		else
			dtoPublisher.setUserRole(UserRole.ADMIN);
		logger.info("saved data in mongo");
		producer.sendMessageToRabbitMq(dtoPublisher);
		userRepository.save(registratingUser);
		logger.info("Your account is successfully created with us");
		return "Your account is successfully created with us";
	}

	public User validateUserDetails(UserDto userDto) {
		User user = new User();
		boolean isEmailPresent = userRepository.existsByEmailId(userDto.getEmailId());
		if (userDto.getEmailId() == null || userDto.getEmailId().isEmpty()) {
			throw new InValidEmailException("Email id can't be blank");
		} else if (isEmailPresent)
			throw new EmailAlreadyExistsException("Your email id is already registred");
		else
			user.setEmailId(userDto.getEmailId());

		if (userDto.getMobileNumber() == null || userDto.getMobileNumber().isEmpty()) {
			throw new InValidEmailException("Mobile number can't be blank");
		} else {
			user.setMobileNumber(userDto.getMobileNumber());
		}
		user.setRoles(userDto.getRole());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setCountry(userDto.getCountry());
		logger.info("Validating user");
		return user;
	}

	@Override
	public User getUserByDetails(String emailId) {
		Optional<User> userFromDb = userRepository.findById(emailId);
		if (!userFromDb.isPresent()) {
			throw new UserIsNotPresentException(errorMessage);
		}
		return userFromDb.get();
	}

	@Override
	public User updateUserName(String emailId, UserDto userDto) {
		User userFromDb = userRepository.findById(emailId)
				.orElseThrow(() -> new UserIsNotPresentException(errorMessage));

		userFromDb.setFirstName(userDto.getFirstName());
		userFromDb.setLastName(userDto.getLastName());
		return userRepository.save(userFromDb);
	}

	@Override
	public User updateMobileNumber(String emailId, String mobileNumber) {
		User userFromDb = userRepository.findById(emailId)
				.orElseThrow(() -> new UserIsNotPresentException(errorMessage));
		userFromDb.setMobileNumber(mobileNumber);
		return userRepository.save(userFromDb);
	}

	@Override
	public User updateCity(String emailId, String city) {
		User userFromDb = userRepository.findById(emailId)
				.orElseThrow(() -> new UserIsNotPresentException(errorMessage));
		userFromDb.setCity(city);
		return userRepository.save(userFromDb);
	}

	@Override
	public User updateState(String emailId, String state) {
		User userFromDb = userRepository.findById(emailId)
				.orElseThrow(() -> new UserIsNotPresentException(errorMessage));
		userFromDb.setState(state);
		return userRepository.save(userFromDb);
	}

	@Override
	public User updateCountry(String emailId, String country) {
		User userFromDb = userRepository.findById(emailId)
				.orElseThrow(() -> new UserIsNotPresentException(errorMessage));
		userFromDb.setCountry(country);
		return userRepository.save(userFromDb);
	}

}
