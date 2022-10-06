//package com.stackroute.productservice.serviceImpl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.productservice.modal.Course;
//import com.stackroute.productservice.repository.CourseRepository;
//import com.stackroute.productservice.service.CourseService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class CourseServiceImplTest {
//
//	@Autowired
//	private CourseService courseService;
//
//	@MockBean
//	private CourseRepository courseRepository;

//	@Test
//	void testAddCourse() {
//
//		assertThrows(NullPointerException.class, () -> {
//			Course course = new Course();
//			course.setCourseId(1L);
//			course.setCourseName("java");
//			course.setCourseFee(500.00);
//			course.setLanguage("english");
//			course.setCourseImage(null);
//
//			when(courseRepository.save(course)).thenReturn(course);
//			Course savedCourse = courseService.addCourse(course, null);
//			assertEquals(course, savedCourse);
//
//		});
//
//	}
//
//	@Test
//	void testGetAllCourses() {
//		Course course1 = new Course();
//		course1.setCourseId(1L);
//		course1.setCourseName("java");
//		course1.setCourseFee(500.00);
//		course1.setLanguage("english");
//
//		Course course2 = new Course();
//		course2.setCourseId(2L);
//		course2.setCourseName("python");
//		course2.setCourseFee(500.00);
//		course2.setLanguage("english");
//
//		when(courseRepository.findAll()).thenReturn(List.of(course1, course2));
//
//		List<Course> allCourses = courseService.getAllCourses();
//		assertEquals(2, allCourses.size());
//		assertEquals(List.of(course1, course2), allCourses);
//
//	}
//
//	@Test
//	void testGetCourseById() {
//		Course course = new Course();
//		course.setCourseId(1L);
//
//		when(courseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
//
//		Course courseById = courseService.getCourseById(course.getCourseId());
//		assertEquals(course, courseById);
//
//	}
//
//	@Test
//	void testGetCourseByMentorEmailId() {
//		Course course = new Course();
//		course.setMentorEmailId("abhi@gmail.com");
//
//		when(courseRepository.findByMentorEmailId(course.getMentorEmailId())).thenReturn(List.of(course));
//		List<Course> courseByMentorEmailId = (List<Course>) courseService.getCourseByMentorEmailId("abhi@gmail.com");
//
//		assertEquals(course, courseByMentorEmailId.get(0));
//	}
//
//	@Test
//	void testGetCourseByLearnerEmailId() {
//		Course course = new Course();
//		course.setMentorEmailId("abhi@gmail.com");
//
//		when(courseRepository.findByLearnerEmailId("abhi@gmail.com")).thenReturn(List.of(course));
//		List<Course> courseByLearnerEmailId = (List<Course>) courseService.getCourseByLearnerEmailId("abhi@gmail.com");
//
//		assertEquals(course, courseByLearnerEmailId.get(0));
//	}

//}
