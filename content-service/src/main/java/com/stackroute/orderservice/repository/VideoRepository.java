package com.stackroute.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.orderservice.modal.Video;

@Repository
public interface VideoRepository extends MongoRepository<Video, Long> {

}
