package com.stackroute.chatservice.modal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Q&A_details")
public class ChatOpenForumModal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long commentId;
	private Long courseId;
	private String emailId;
	private List<ReplierModal> reply;
	private LocalDate dateofComment;
	private String question;

	@Transient
	public static final String SEQUENCE_NAME = "comment_Id_Sequence";

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<ReplierModal> getreply() {
		return reply;
	}

	public void setreply(List<ReplierModal> reply) {
		this.reply = reply;
	}

	public LocalDate getDateofComment() {
		return dateofComment;
	}

	public void setDateofComment(LocalDate dateofComment) {
		this.dateofComment = dateofComment;
	}

	public ChatOpenForumModal() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ChatOpenForumModal(Long commentId, Long courseId, String emailId, List<ReplierModal> reply,
			LocalDate dateofComment, String question) {
		super();
		this.commentId = commentId;
		this.courseId = courseId;
		this.emailId = emailId;
		this.reply = reply;
		this.dateofComment = dateofComment;
		this.question = question;
	}

}
