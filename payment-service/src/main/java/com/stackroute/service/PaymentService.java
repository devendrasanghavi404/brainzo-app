package com.stackroute.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.razorpay.RazorpayException;
import com.stackroute.modal.Payment;

public interface PaymentService {
	
	Payment addPayment(Payment payment, MultipartFile file) throws RazorpayException;
	
	Payment getPaymentByOrderId(String orderId);
	
	List<Payment> getPaymentByMentorEmailId(String mentorEmailId);
	
	List<Payment> getPaymentByLearnerEmailId(String learnerEmailId);
	
	Payment updatePayment(Payment payment);

}
