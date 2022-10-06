package com.stackroute.orderservice.modal;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Video {

	@Transient
	public static final String SEQUENCE_NAME = "video_sequence";

	
	private Long videoId;
	private String videoTitle;
	private String videoLink;
	
	public Video() {
		super();
	}
	public Video(Long videoId, String videoTitle, String videoLink) {
		super();
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.videoLink = videoLink;
	}
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	

}
