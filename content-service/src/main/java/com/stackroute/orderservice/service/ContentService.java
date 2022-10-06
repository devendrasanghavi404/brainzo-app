package com.stackroute.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stackroute.orderservice.modal.CourseContent;
import com.stackroute.orderservice.modal.Video;

public interface ContentService {

	// add method
	public void addContent(ArrayList<CourseContent> content);

	public void addVideo(Video video);

	// retrieve methods
	public List<CourseContent> getAllContent();

	public List<Video> getAllVideos();

	public Optional<CourseContent> getContentById(Long contentId);

	public Optional<Video> getVideoById(Long videoId);

	// update method
	public void updateContentById(CourseContent content, Long conentId);

	public void updateVideoById(Long contentId, Video video, Long videoId);

	// delete
	public void deleteContentById(Long conentId);

	public void deleteVideoById(Video video, Long videoId);

}
