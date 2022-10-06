package com.stackroute.Service;

import com.stackroute.Entity.EmailDetails;

public interface EmailService {

	/*
	 *  Method  To send a simple email
	 */
	String sendSimpleMail(EmailDetails details);

}
