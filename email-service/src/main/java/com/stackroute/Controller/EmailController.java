package com.stackroute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.Entity.EmailDetails;
import com.stackroute.Service.EmailService;

@RestController
//Class
public class EmailController {

 @Autowired 
 private EmailService emailService;

 // Sending a simple Email
 @PostMapping("/sendMail")
 public String
 sendMail(@RequestBody EmailDetails details)
 {
     String status= emailService.sendSimpleMail(details);

     return status;
 }


}