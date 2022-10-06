package com.stackroute.productservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.bson.types.Binary;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.productservice.enums.CourseType;
import com.stackroute.productservice.modal.Course;
import com.stackroute.productservice.service.CourseService;
import com.stackroute.productservice.serviceImpl.SequenceGeneratorService;

@ContextConfiguration(classes = { CourseController.class })
@ExtendWith(SpringExtension.class)
class CourseControllerTest {
	@Autowired
	private CourseController courseController;
	@MockBean
	private CourseService courseService;
	@MockBean
	private SequenceGeneratorService sequenceGeneratorService;

	@Test
	@Disabled()
	void testAddCourse() throws IOException {

	}

	@Test
	void testGetAllCourses() throws Exception {
		when(courseService.getAllCourses()).thenReturn(new ArrayList<>());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brainzo/courses");
		MockMvcBuilders.standaloneSetup(courseController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string("[]"));
	}

	@Test
	void testGetCourseById() throws Exception {
		Course course = new Course();
		course.setCourseFee(10.0d);
		course.setCourseId(123L);
		course.setCourseImage(new Binary("AAAAAAAA".getBytes("UTF-8")));
		course.setCourseName("Java course");
		course.setCourseReview(new ArrayList<>());
		course.setCourseType(CourseType.LIVE);
		course.setDescription("This is java course");
		course.setLanguage("english");
		course.setLearner(new ArrayList<>());
		course.setMentorEmailId("abhi@gmail.com");
		when(courseService.getCourseById(anyLong())).thenReturn(course);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brainzo/courses/{courseId}", 123L);
		MockMvcBuilders.standaloneSetup(courseController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string(
						"{\"courseId\":123,\"mentorEmailId\":\"abhi@gmail.com\",\"courseName\":\"Java course\",\"courseImage\":{\"type\":0,\"data\":"
								+ "\"QUFBQUFBQUE=\"},\"courseFee\":10.0,\"description\":\"This is java course\",\"courseReview"
								+ "\":[],\"courseType\":\"live\",\"language\":\"english\",\"learner\":[]}"));
	}

	@Test
	void testGetCourseByLearnerEmailId() throws Exception {
		when(courseService.getCourseByLearnerEmailId((String) any())).thenReturn(new ArrayList<>());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/brainzo/courses/learnerEmailId/{learnerEmailId}", "abhi@gmail.com");
		MockMvcBuilders.standaloneSetup(courseController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string("[]"));
	}

	@Test
	void testGetCourseByMentorEmailId() throws Exception {
		when(courseService.getCourseByMentorEmailId((String) any())).thenReturn(new ArrayList<>());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/brainzo/courses/mentorEmailId/{mentorEmailId}", "abhi@gmail.com");
		MockMvcBuilders.standaloneSetup(courseController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string("[]"));
	}
}