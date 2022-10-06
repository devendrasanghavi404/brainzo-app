package com.stackroute.chatservice.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.chatservice.constants.ChatOpenForumConstant;
import com.stackroute.chatservice.exception.CommentNotFoundException;
import com.stackroute.chatservice.modal.ChatOpenForumModal;
import com.stackroute.chatservice.repository.ChatOpenForumRepository;
import com.stackroute.chatservice.service.ChatOpenForumService;

@Service
public class ChatOpenForumServiceImpl implements ChatOpenForumService {

	@Autowired
	private ChatOpenForumRepository chatOpenForumRepository;

	@Autowired
	private SequenceGeneratorServiceImpl sequenceGeneratorServiceImpl;

	@Override
	public List<ChatOpenForumModal> getAllComments() {
		return chatOpenForumRepository.findAll();
	}

	@Override
	public String addComment(ChatOpenForumModal chatOpenForumModal) {
		chatOpenForumModal
				.setCommentId(sequenceGeneratorServiceImpl.getSequenceNumber(ChatOpenForumModal.SEQUENCE_NAME));
		chatOpenForumModal.setCourseId(chatOpenForumModal.getCourseId());
		chatOpenForumModal.setDateofComment(LocalDate.now());
		chatOpenForumModal.setEmailId(chatOpenForumModal.getEmailId());
		chatOpenForumModal.setQuestion(chatOpenForumModal.getQuestion());
		chatOpenForumRepository.save(chatOpenForumModal);
		return ChatOpenForumConstant.COMMENT_ADDED;
	}

	@Override
	public String deleteComment(String emailId, String reply) {
		chatOpenForumRepository.deleteByEmailIdAndReply(emailId, reply);
		return ChatOpenForumConstant.COMMENT_DELETED;

	}

	@Override
	public List<ChatOpenForumModal> getCommentByCourseId(Long courseId) {
		List<ChatOpenForumModal> allCoursesById = chatOpenForumRepository.findByCourseId(courseId);
		if (allCoursesById.isEmpty())
			throw new CommentNotFoundException(ChatOpenForumConstant.COMMENT_NOT_FOUND);
		else
			return allCoursesById;
	}

	@Override
	public String addReplyByCommentId(Long commentId, ChatOpenForumModal replyOverComment) {
		ChatOpenForumModal openForumModal = chatOpenForumRepository.findByCommentId(commentId)
				.orElseThrow(() -> new CommentNotFoundException(ChatOpenForumConstant.COMMENT_ID_NOT_FOUND));
		chatOpenForumRepository.deleteByCommentId(commentId);
		openForumModal.setreply(replyOverComment.getreply());
		chatOpenForumRepository.save(openForumModal);
		return ChatOpenForumConstant.COMMENT_ADDED;
	}

}
