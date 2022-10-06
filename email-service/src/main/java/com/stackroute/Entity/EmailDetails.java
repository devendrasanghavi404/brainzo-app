package com.stackroute.Entity;
import java.util.Date;
public class EmailDetails {

	private String recieverEmail;
	private String messageBody;
	private String subject;
	
	public EmailDetails() {
		super();
	}

	public EmailDetails(String senderEmail, String recieverEmail, String messageBody, String subject) {
		super();
		this.recieverEmail = recieverEmail;
		this.messageBody = messageBody;
		this.subject = subject;
	}


	public String getRecieverEmail() {
		return recieverEmail;
	}

	public void setRecieverEmail(String recieverEmail) {
		this.recieverEmail = recieverEmail;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
