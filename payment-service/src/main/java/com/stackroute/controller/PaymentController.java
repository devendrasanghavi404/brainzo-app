package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.razorpay.RazorpayException;
import com.stackroute.modal.Payment;
import com.stackroute.service.PaymentService;

@RestController
@RequestMapping("/brainzo")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping(value = "/payment")
	ResponseEntity<Payment> addPayment(@RequestParam("payment") String payment,@RequestParam("file") MultipartFile file) throws RazorpayException{
		Gson gson = new Gson();
		Payment fromJson = gson.fromJson(payment, Payment.class);
		return new ResponseEntity<Payment>(paymentService.addPayment(fromJson, file),HttpStatus.OK);
	}
	
	@PutMapping(value = "/payment/update")
	ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) throws RazorpayException{
		return new ResponseEntity<Payment>(paymentService.updatePayment(payment),HttpStatus.OK);
	}
	
	@GetMapping(value = "/payment/{orderId}")
	ResponseEntity<Payment> getPaymentByPaymentId(@PathVariable String orderId){
		return new ResponseEntity<Payment>(paymentService.getPaymentByOrderId(orderId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/payment/learnerEmailId/{learnerEmailId}")
	ResponseEntity<List<Payment>> getPaymentByLearnerEmailId(@PathVariable String learnerEmailId){
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentByLearnerEmailId(learnerEmailId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/payment/mentorEmailId/{mentorEmailId}")
	ResponseEntity<List<Payment>> getPaymentByMentorEmailId(@PathVariable String mentorEmailId){
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentByMentorEmailId(mentorEmailId),HttpStatus.OK);
	}
	
	

}
