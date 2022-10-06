package com.stackroute.productservice.service;

import java.io.IOException;
import java.util.List;

import com.stackroute.productservice.modal.Learner;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.productservice.modal.Course;
import com.stackroute.productservice.modal.Learner;

public interface CourseService {

	Course addCourse(Course course, MultipartFile file) throws IOException;

	List<Course> getAllCourses();

	Course getCourseById(long courseId);

	List<Course> getCourseByLearnerEmailId(String learnerEmailId);

	List<Course> getCourseByMentorEmailId(String mentorEmailId);
	Learner addLearnerInCourse(Learner learner,long contentId);



}
