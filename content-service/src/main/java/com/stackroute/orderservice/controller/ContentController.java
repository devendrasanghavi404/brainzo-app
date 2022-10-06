package com.stackroute.orderservice.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.orderservice.modal.CourseContent;
import com.stackroute.orderservice.modal.Video;
import com.stackroute.orderservice.repository.ContentRepository;
import com.stackroute.orderservice.service.ContentService;
import com.stackroute.orderservice.service.impl.SequenceGeneratorService;

@RestController
@RequestMapping(value = "/brainzo/content")
public class ContentController {

	Logger logger = LoggerFactory.getLogger(ContentController.class);

	@Autowired
	private ContentService contentService;
	@Autowired
	private ContentRepository contentRepository;
	@Autowired
	SequenceGeneratorService service;

	@GetMapping(value = "/contents")
	public ResponseEntity<List<CourseContent>> getAllContent() {
		logger.info("inside getAllContent method");
		return new ResponseEntity<List<CourseContent>>(contentService.getAllContent(), HttpStatus.OK);
	}

	@PostMapping(value = "/addContent")
	public ResponseEntity<CourseContent> addContent(@RequestBody CourseContent content) {
		logger.info("inside add content");
		return new ResponseEntity<CourseContent>(contentRepository.save(content), HttpStatus.OK);
	}

	@PutMapping(value = "/updateVideo")
	public ResponseEntity<Video> updateVideo(@RequestParam Long contentId, String videoTitle) throws Exception {
		logger.info("inside add video");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://youtube138.p.rapidapi.com/search/?q=" + videoTitle + "&hl=en&gl=US"))
				.header("X-RapidAPI-Key", "e3a569defemsh22582aa5ef28982p10e4fejsn6bbc7bd97afe")
				.header("X-RapidAPI-Host", "youtube138.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject object = new JSONObject(response.body());
		Object object3 = object.get("contents");
		JSONArray josn = new JSONArray();
		josn = (JSONArray) object3;
		Object objectsss = josn.get(0);
		JSONObject object1 = new JSONObject();
		object1 = (JSONObject) objectsss;
		JSONObject object12 = new JSONObject();
		object12 = (JSONObject) object1.get("video");
		Video video = new Video();
		video.setVideoLink(object12.get("videoId").toString());
		video.setVideoTitle(object12.get("title").toString());
		contentService.updateVideoById(contentId, video, contentId);
		return new ResponseEntity<Video>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{contentId}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long contentId) {
		logger.info("inside delete course");
		try {
			contentService.deleteContentById(contentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Content deleted", HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "/update-content/{contentId}")
	public ResponseEntity<String> updateContent(@RequestBody CourseContent content, @PathVariable Long contentId) {
		logger.info("inside update content");
		contentService.updateContentById(content, contentId);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}

}
