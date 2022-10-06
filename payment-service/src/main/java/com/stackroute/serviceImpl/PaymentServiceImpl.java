package com.stackroute.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.exception.OrderIdNotFoundException;
import com.stackroute.modal.Payment;
import com.stackroute.repository.PaymentRepository;
import com.stackroute.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	


	@Override
	public Payment addPayment(Payment payment, MultipartFile file) throws RazorpayException {
		try {
			payment.setCourseImage(new Binary(BsonBinarySubType.BINARY,file.getBytes()));
//			payment.setPaymentId("PID"+generatePaymentId());
			
			
			double coursePrice = payment.getCoursePrice();
			coursePrice = coursePrice * 100;
			
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_MQMXX4nrBFTO02", "SqCQ0tvunCmXBwJLXvtWvkeh");
			JSONObject options = new JSONObject();
			options.put("amount", coursePrice);
			options.put("currency", "INR");
			options.put("receipt", "txn_123456");
			
			// creating order in razor pay by adding amount, currency and receipt details
			Order orderCreated = razorpayClient.orders.create(options);
			
			payment.setStatus(orderCreated.get("status"));
			payment.setReceipt(orderCreated.get("receipt"));
			payment.setOrderId(orderCreated.get("id"));
			
			//converting coursePrice in double
			double amount = Double.valueOf(orderCreated.get("amount")+"");
			amount /=100; //to convert paise to INR
			payment.setCoursePrice(amount);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Payment savedPayment = paymentRepository.save(payment);
		return savedPayment;
	}
	
	@Override
	public Payment updatePayment(Payment payment) {
		String orderId = payment.getOrderId();
		Optional<Payment> findById = paymentRepository.findById(orderId);
		Payment updatedPayment=null;
		if (findById.isPresent()) {
			Payment payment2 = findById.get();
			payment2.setPaymentId(payment.getPaymentId());
			payment2.setStatus(payment.getStatus());
			updatedPayment = paymentRepository.save(payment2);
			return updatedPayment;
		} else {
			throw new OrderIdNotFoundException("SERVICE.PAYMENT_NOT_FOUND");
		}
		
		
		
	}

	@Override
	public Payment getPaymentByOrderId(String orderId) {
		Optional<Payment> findById = paymentRepository.findById(orderId);
		if (findById.isPresent()) {
			Payment paymentByOrderId = findById.get();
			return paymentByOrderId;
		} else {
			throw new OrderIdNotFoundException("SERVICE.PAYMENT_NOT_FOUND");
		}
	}

	@Override
	public List<Payment> getPaymentByMentorEmailId(String mentorEmailId) {
		List<Payment> findByMentorEmailId = paymentRepository.findByMentorEmailId(mentorEmailId);
		
		if (findByMentorEmailId.isEmpty()) {
			throw new OrderIdNotFoundException("SERVICE.PAYMENT_NOT_FOUND_WITH_EMAIL");
		} else {
			return findByMentorEmailId;
		}
		
	}

	@Override
	public List<Payment> getPaymentByLearnerEmailId(String learnerEmailId) {
		List<Payment> findByLearnerEmailId = paymentRepository.findByLearnerEmailId(learnerEmailId);
		
		if (findByLearnerEmailId.isEmpty()) {
			throw new OrderIdNotFoundException("SERVICE.PAYMENT_NOT_FOUND_WITH_EMAIL");
		} else {
			return findByLearnerEmailId;
		}
		
	}

	

}
