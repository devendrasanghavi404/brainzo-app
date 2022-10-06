package com.stackroute.orderservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.orderservice.modal.CourseContent;
import com.stackroute.orderservice.modal.Video;
import com.stackroute.orderservice.repository.ContentRepository;
import com.stackroute.orderservice.repository.VideoRepository;
import com.stackroute.orderservice.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	Logger logger = LoggerFactory.getLogger(ContentService.class);

	@Autowired
	private ContentRepository conRepo;

	@Autowired
	private VideoRepository vidRepo;

	@Override
	public void addContent(ArrayList<CourseContent> content) {
		logger.info("inside add service content");
		try {
			conRepo.saveAll(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addVideo(Video video) {
		logger.info("inside video service");
		vidRepo.save(video);
	}

	@Override
	public List<CourseContent> getAllContent() {
		logger.info("inside List get all content");
		return conRepo.findAll();
	}

	@Override
	public List<Video> getAllVideos() {
		logger.info("inside list video service");
		return vidRepo.findAll();
	}

	@Override
	public Optional<CourseContent> getContentById(Long contentId) {
		logger.info("inside get content by ID");
		Optional<CourseContent> optional = Optional.ofNullable(conRepo.findById(contentId).get());
		return optional;
	}

	@Override
	public Optional<Video> getVideoById(Long videoId) {
		logger.info("inside get videoById");
		Optional<Video> optional = Optional.ofNullable(vidRepo.findById(videoId).get());
		return optional;
	}

	@Override
	public void updateContentById(CourseContent content, Long conentId) {
		CourseContent currentContent = conRepo.findById(conentId).get();
		currentContent.setContentId(conentId);
		currentContent.setCourseName(content.getCourseName());
		currentContent.setUserEmailId(content.getUserEmailId());
		currentContent.setVideo(content.getVideo());
		conRepo.save(currentContent);
	}

	@Override
	public void updateVideoById(Long contentId, Video video, Long videoId) {
		CourseContent content = conRepo.findById(contentId).get();
		content.getVideo().add(video);
		conRepo.save(content);
	}

	@Override
	public void deleteContentById(Long contentId) {
		CourseContent currentContent = conRepo.findById(contentId).get();
		conRepo.delete(currentContent);
	}

	@Override
	public void deleteVideoById(Video video, Long videoId) {
		Video currentVideo = vidRepo.findById(videoId).get();
		vidRepo.delete(currentVideo);
	}

}
