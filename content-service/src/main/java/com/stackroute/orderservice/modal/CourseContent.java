package com.stackroute.orderservice.modal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CourseContent {

//	@Transient
//	public static final String SEQUENCE_NAME = "course_content";

	@Id
	private Long contentId;
	private String courseName;
	private String userEmailId;
	private List<Video> video;
	
	public CourseContent() {
		super();
	}
	public CourseContent(Long contentId, String courseName, String userEmailId, List<Video> video) {
		super();
		this.contentId = contentId;
		this.courseName = courseName;
		this.userEmailId = userEmailId;
		this.video = video;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public List<Video> getVideo() {
		return video;
	}
	public void setVideo(List<Video> video) {
		this.video = video;
	}
//	public static String getSequenceName() {
//		return SEQUENCE_NAME;
//	}
	

}
