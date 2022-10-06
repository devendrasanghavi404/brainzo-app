package com.stackroute.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.modal.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
	
	//@Query(value = "{'mentorEmailId':?0}")
	List<Payment> findByMentorEmailId(String mentorEmailId);
	
	//@Query(value = "{'learnerEmailId':?0}")
	List<Payment> findByLearnerEmailId(String learnerEmailId);
	
//	@Query(value = "{orderId : ?0}")
//	Payment  findByOrderId(String orderId);

}
