package com.stackroute.productservice.controller;

import java.io.IOException;
import java.util.List;

import com.stackroute.productservice.modal.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.stackroute.productservice.modal.Course;
import com.stackroute.productservice.service.CourseService;
import com.stackroute.productservice.serviceImpl.SequenceGeneratorService;

@RestController
@RequestMapping("/brainzo")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	SequenceGeneratorService service;

	@PostMapping(value = "/course")
	ResponseEntity<Course> addCourse(@RequestParam("course") String course, @RequestParam("file") MultipartFile file)
			throws IOException {
		Gson gson = new Gson();
		Course courseFileObj = gson.fromJson(course, Course.class);
		Course addedCourse = courseService.addCourse(courseFileObj, file);
		return new ResponseEntity<>(addedCourse, HttpStatus.OK);
	}

	@GetMapping(value = "/courses")
	ResponseEntity<List<Course>> getAllCourses() {
		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping(value = "/courses/{courseId}")
	ResponseEntity<Course> getCourseById(@PathVariable long courseId) {
		return new ResponseEntity<Course>(courseService.getCourseById(courseId), HttpStatus.OK);
	}

	@GetMapping(value = "/courses/learnerEmailId/{learnerEmailId}")
	ResponseEntity<List<Course>> getCourseByLearnerEmailId(@PathVariable String learnerEmailId) {
		return new ResponseEntity<>(courseService.getCourseByLearnerEmailId(learnerEmailId), HttpStatus.OK);
	}

	@GetMapping(value = "/courses/mentorEmailId/{mentorEmailId}")
	ResponseEntity<List<Course>> getCourseByMentorEmailId(@PathVariable String mentorEmailId) {
		return new ResponseEntity<>(courseService.getCourseByMentorEmailId(mentorEmailId), HttpStatus.OK);
	}

	@PutMapping(value = "/courses/learner")
	ResponseEntity<Learner> addLearner(@RequestParam long courseId, @RequestBody Learner learner) {
		return new ResponseEntity<>(courseService.addLearnerInCourse(learner, courseId), HttpStatus.OK);
	}

}
