package com.stackroute.orderservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.orderservice.modal.CourseContent;
import com.stackroute.orderservice.repository.ContentRepository;
import com.stackroute.orderservice.repository.VideoRepository;
import com.stackroute.orderservice.service.ContentService;
import com.stackroute.orderservice.service.impl.SequenceGeneratorService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = { ContentController.class })
@ExtendWith(SpringExtension.class)
class ContentControllerTest {
	@Autowired
	private ContentController contentController;

	@MockBean
	private ContentRepository contentRepository;

	@MockBean
	private ContentService contentService;

	@MockBean
	private SequenceGeneratorService sequenceGeneratorService;

	@MockBean
	private VideoRepository videoRepository;

	@Test
	void testAddContent() throws Exception {
		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("Java Course");
		courseContent.setUserEmailId("devendra.s@abc.com");
		courseContent.setVideo(new ArrayList<>());
		when(contentRepository.save((CourseContent) any())).thenReturn(courseContent);
		when(sequenceGeneratorService.getSequenceNumber((String) any())).thenReturn(1L);

		CourseContent courseContent1 = new CourseContent();
		courseContent1.setContentId(123L);
		courseContent1.setCourseName("Java Course");
		courseContent1.setUserEmailId("devendra.s@abc.com");
		courseContent1.setVideo(new ArrayList<>());
		String content = (new ObjectMapper()).writeValueAsString(courseContent1);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/brainzo/content/addContent")
				.contentType(MediaType.APPLICATION_JSON).content(content);
		MockMvcBuilders.standaloneSetup(contentController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string(
						"{\"contentId\":123,\"courseName\":\"Java Course\",\"userEmailId\":\"devendra.s@abc.com\",\"video\":[]}"));
	}

	@Test
	void testGetAllContent() throws Exception {
		when(contentService.getAllContent()).thenReturn(new ArrayList<>());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brainzo/content/contents");
		MockMvcBuilders.standaloneSetup(contentController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string("[]"));
	}

	@Test
	void testDeleteCourse() throws Exception {
		doNothing().when(contentService).deleteContentById((Long) any());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/brainzo/content/delete/{contentId}", 123L);
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(contentController).build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Content deleted"));
	}

	@Test
	void testUpdateContent() throws Exception {
		doNothing().when(contentService).updateContentById((CourseContent) any(), (Long) any());

		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("Angular for Dummies");
		courseContent.setUserEmailId("ayush@abc.com");
		courseContent.setVideo(new ArrayList<>());
		String content = (new ObjectMapper()).writeValueAsString(courseContent);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/brainzo/content/update-content/{contentId}", 123L).contentType(MediaType.APPLICATION_JSON)
				.content(content);
		MockMvcBuilders.standaloneSetup(contentController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Updated"));
	}

	@Test
	void testUpdateVideo() throws Exception {
		MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/brainzo/content/updateVideo",
				"Uri Test Variable", "Uri Test Variable");
		MockHttpServletRequestBuilder requestBuilder = putResult.param("videoTitle", "Java Introduction");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(contentController).build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
	}
}
