package com.stackroute.productservice.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.stackroute.productservice.modal.Learner;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.productservice.exception.CourseIdNotFoundException;
import com.stackroute.productservice.modal.Course;
import com.stackroute.productservice.modal.Learner;
import com.stackroute.productservice.repository.CourseRepository;
import com.stackroute.productservice.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	SequenceGeneratorService service;

	@Override
	public Course addCourse(Course course, MultipartFile file) throws IOException {
		course.setCourseId(service.getSequenceNumber(course.SEQUENCE_NAME));
		course.setCourseImage((new Binary(BsonBinarySubType.BINARY, file.getBytes())));
		Course addedCourse = courseRepo.save(course);
		return addedCourse;
	}

	@Override
	public List<Course> getAllCourses() {
		logger.info("info message");
		List<Course> allCourses = courseRepo.findAll();
		return allCourses;
	}

	@Override
	public Course getCourseById(long courseId) {
		Optional<Course> courseFromRepo = courseRepo.findById(courseId);
		if (courseFromRepo.isPresent()) {
			return courseFromRepo.get();
		} else {
			throw new CourseIdNotFoundException("SERVICE.COURSE_NOT_FOUND");
		}

	}

	@Override
	public List<Course> getCourseByLearnerEmailId(String learnerEmailId) {
		List<Course> courseByLearnerEmailId = courseRepo.findByLearnerEmailId(learnerEmailId);
		if (courseByLearnerEmailId.isEmpty()) {
			throw new CourseIdNotFoundException("SERVICE.COURSE_NOT_FOUND_WITH_EMAIL");
		} else {
			return courseByLearnerEmailId;
		}

	}

	@Override
	public List<Course> getCourseByMentorEmailId(String mentorEmailId) {
		List<Course> findByMentorEmailId = courseRepo.findByMentorEmailId(mentorEmailId);
		if (findByMentorEmailId.isEmpty()) {
			throw new CourseIdNotFoundException("SERVICE.COURSE_NOT_FOUND_WITH_EMAIL");
		} else {
			return findByMentorEmailId;
		}

	}

	@Override
	public Learner addLearnerInCourse(Learner learner, long courseId) {
		Course course = getCourseById(courseId);
		List<Learner> list = course.getLearner();
		list.add(learner);
		course.setLearner(list);
		courseRepo.save(course);
		return learner;

	}

}
