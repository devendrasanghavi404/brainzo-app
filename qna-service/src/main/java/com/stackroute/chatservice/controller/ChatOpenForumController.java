package com.stackroute.chatservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.chatservice.constants.ChatOpenForumConstant;
import com.stackroute.chatservice.modal.ChatOpenForumModal;
import com.stackroute.chatservice.serviceimpl.ChatOpenForumServiceImpl;

@RestController
@RequestMapping(value = "api/v1/brainzo/qna")
public class ChatOpenForumController {

	@Autowired
	private ChatOpenForumServiceImpl chatOpenForumServiceImpl;

	@GetMapping(value = "/comments")
	ResponseEntity<List<ChatOpenForumModal>> getAllComment() {
		List<ChatOpenForumModal> allComments = chatOpenForumServiceImpl.getAllComments();
		return new ResponseEntity<>(allComments, HttpStatus.OK);
	}

	@PostMapping(value = "/addcomment")
	ResponseEntity<String> addComment(@RequestBody ChatOpenForumModal chatOpenForumModal) {
		chatOpenForumServiceImpl.addComment(chatOpenForumModal);
		return new ResponseEntity<>(ChatOpenForumConstant.COMMENT_ADDED, HttpStatus.ACCEPTED);

	}

	@GetMapping(value = "/comment")
	ResponseEntity<List<ChatOpenForumModal>> getCommentByCourseId(@RequestParam Long courseId) {
		List<ChatOpenForumModal> allCommentByCourseId = chatOpenForumServiceImpl.getCommentByCourseId(courseId);
		return new ResponseEntity<>(allCommentByCourseId, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	ResponseEntity<String> deleteComment(@RequestParam String emailId, @RequestParam String reply) {
		chatOpenForumServiceImpl.deleteComment(emailId, reply);
		return new ResponseEntity<>(ChatOpenForumConstant.COMMENT_DELETED, HttpStatus.OK);

	}

	@PutMapping(value = "/comment")
	ResponseEntity<String> addCommentsOverComment(@RequestParam Long commentId,
			@RequestBody ChatOpenForumModal replyOverComment) {
		chatOpenForumServiceImpl.addReplyByCommentId(commentId, replyOverComment);
		return new ResponseEntity<>(ChatOpenForumConstant.COMMENT_ADDED, HttpStatus.OK);

	}

}
