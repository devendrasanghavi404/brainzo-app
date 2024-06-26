package com.stackroute.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.stackroute.Entity.EmailDetails;
import com.stackroute.Service.EmailService;
@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") 
    private String sender;

	@Override
	public String sendSimpleMail(EmailDetails details) {
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecieverEmail());
            mailMessage.setText(details.getMessageBody());
            mailMessage.setSubject(details.getSubject());
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
	}

	
}
