package com.stackroute.chatservice.service;

import java.util.List;

import com.stackroute.chatservice.modal.ChatOpenForumModal;

public interface ChatOpenForumService {

	List<ChatOpenForumModal> getAllComments();

	String addComment(ChatOpenForumModal chatOpenForumModal);

	String deleteComment(String emailId, String reply);

	List<ChatOpenForumModal> getCommentByCourseId(Long courseId);

	String addReplyByCommentId(Long commentId, ChatOpenForumModal replyOverComment);

}
