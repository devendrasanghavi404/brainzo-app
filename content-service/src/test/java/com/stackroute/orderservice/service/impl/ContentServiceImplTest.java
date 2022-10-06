package com.stackroute.orderservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stackroute.orderservice.modal.CourseContent;
import com.stackroute.orderservice.modal.Video;
import com.stackroute.orderservice.repository.ContentRepository;
import com.stackroute.orderservice.repository.VideoRepository;

@ContextConfiguration(classes = { ContentServiceImpl.class })
@ExtendWith(SpringExtension.class)
class ContentServiceImplTest {
	@MockBean
	private ContentRepository contentRepository;

	@Autowired
	private ContentServiceImpl contentServiceImpl;

	@MockBean
	private VideoRepository videoRepository;

	@Test
	void testAddContent() {
		when(contentRepository.saveAll((Iterable<CourseContent>) any())).thenReturn(new ArrayList<>());
		contentServiceImpl.addContent(new ArrayList<>());
		verify(contentRepository).saveAll((Iterable<CourseContent>) any());
		assertTrue(contentServiceImpl.getAllContent().isEmpty());
		assertTrue(contentServiceImpl.getAllVideos().isEmpty());
	}

	@Test
	void testAddVideo() {
		when(videoRepository.save((Video) any())).thenReturn(new Video());
		contentServiceImpl.addVideo(new Video());
		verify(videoRepository).save((Video) any());
		assertTrue(contentServiceImpl.getAllContent().isEmpty());
		assertTrue(contentServiceImpl.getAllVideos().isEmpty());
	}

	@Test
	void testGetAllContent() {
		ArrayList<CourseContent> courseContentList = new ArrayList<>();
		when(contentRepository.findAll()).thenReturn(courseContentList);
		List<CourseContent> actualAllContent = contentServiceImpl.getAllContent();
		assertSame(courseContentList, actualAllContent);
		assertTrue(actualAllContent.isEmpty());
		verify(contentRepository).findAll();
	}

	@Test
	void testGetAllVideos() {
		ArrayList<Video> videoList = new ArrayList<>();
		when(videoRepository.findAll()).thenReturn(videoList);
		List<Video> actualAllVideos = contentServiceImpl.getAllVideos();
		assertSame(videoList, actualAllVideos);
		assertTrue(actualAllVideos.isEmpty());
		verify(videoRepository).findAll();
	}

	@Test
	void testGetContentById() {
		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("Angular");
		courseContent.setUserEmailId("devendra@abc.com");
		courseContent.setVideo(new ArrayList<>());
		Optional<CourseContent> ofResult = Optional.of(courseContent);
		when(contentRepository.findById((Long) any())).thenReturn(ofResult);
		assertTrue(contentServiceImpl.getContentById(123L).isPresent());
		verify(contentRepository).findById((Long) any());
	}

	@Test
	void testGetVideoById() {
		when(videoRepository.findById((Long) any())).thenReturn(Optional.of(new Video()));
		assertTrue(contentServiceImpl.getVideoById(123L).isPresent());
		verify(videoRepository).findById((Long) any());
	}

	@Test
	void testUpdateContentById() {
		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("Java Programming");
		courseContent.setUserEmailId("pratik@gmail.com");
		courseContent.setVideo(new ArrayList<>());
		Optional<CourseContent> ofResult = Optional.of(courseContent);

		CourseContent courseContent1 = new CourseContent();
		courseContent1.setContentId(123L);
		courseContent1.setCourseName("Angular Intro");
		courseContent1.setUserEmailId("abhishek@gmail.com");
		courseContent1.setVideo(new ArrayList<>());
		when(contentRepository.save((CourseContent) any())).thenReturn(courseContent1);
		when(contentRepository.findById((Long) any())).thenReturn(ofResult);

		CourseContent courseContent2 = new CourseContent();
		courseContent2.setContentId(123L);
		courseContent2.setCourseName("React Native");
		courseContent2.setUserEmailId("ayush@abc.com");
		courseContent2.setVideo(new ArrayList<>());
		contentServiceImpl.updateContentById(courseContent2, 123L);
		verify(contentRepository).save((CourseContent) any());
		verify(contentRepository).findById((Long) any());
	}

	@Test
	void testUpdateVideoById() {
		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("DotNEt");
		courseContent.setUserEmailId("yash@gmail.com");
		courseContent.setVideo(new ArrayList<>());
		Optional<CourseContent> ofResult = Optional.of(courseContent);

		CourseContent courseContent1 = new CourseContent();
		courseContent1.setContentId(123L);
		courseContent1.setCourseName("Lesson for Java");
		courseContent1.setUserEmailId("mentor@abc.com");
		courseContent1.setVideo(new ArrayList<>());
		when(contentRepository.save((CourseContent) any())).thenReturn(courseContent1);
		when(contentRepository.findById((Long) any())).thenReturn(ofResult);
		contentServiceImpl.updateVideoById(123L, new Video(), 123L);
		verify(contentRepository).save((CourseContent) any());
		verify(contentRepository).findById((Long) any());
	}

	@Test
	void testDeleteContentById() {
		CourseContent courseContent = new CourseContent();
		courseContent.setContentId(123L);
		courseContent.setCourseName("Python");
		courseContent.setUserEmailId("heel@java.com");
		courseContent.setVideo(new ArrayList<>());
		Optional<CourseContent> ofResult = Optional.of(courseContent);
		doNothing().when(contentRepository).delete((CourseContent) any());
		when(contentRepository.findById((Long) any())).thenReturn(ofResult);
		contentServiceImpl.deleteContentById(123L);
		verify(contentRepository).findById((Long) any());
		verify(contentRepository).delete((CourseContent) any());
		assertTrue(contentServiceImpl.getAllContent().isEmpty());
		assertTrue(contentServiceImpl.getAllVideos().isEmpty());
	}

	@Test
	void testDeleteVideoById() {
		doNothing().when(videoRepository).delete((Video) any());
		when(videoRepository.findById((Long) any())).thenReturn(Optional.of(new Video()));
		contentServiceImpl.deleteVideoById(new Video(), 123L);
		verify(videoRepository).findById((Long) any());
		verify(videoRepository).delete((Video) any());
		assertTrue(contentServiceImpl.getAllContent().isEmpty());
		assertTrue(contentServiceImpl.getAllVideos().isEmpty());
	}

}
