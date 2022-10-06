package com.stackroute.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.productservice.modal.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, Long> {

	@Query(value = "{'learner.learnerEmailId':?0}")
	List<Course> findByLearnerEmailId(String learnerEmailId);

	@Query(value = "{'mentorEmailId':?0}")
	List<Course> findByMentorEmailId(String mentorEmailId);

}
