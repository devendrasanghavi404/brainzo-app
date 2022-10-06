package com.stackroute.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.orderservice.modal.CourseContent;

@Repository
public interface ContentRepository extends MongoRepository<CourseContent, Long> {

}
