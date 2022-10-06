package com.stackroute.chatservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.chatservice.modal.ChatOpenForumModal;

@Repository
public interface ChatOpenForumRepository extends MongoRepository<ChatOpenForumModal, Long> {

	@Query(value = "{'emailId' : ?0, 'comments.reply' : ?1}", delete = true)
	String deleteByEmailIdAndReply(String emailId, String reply);

	@Query("{'courseId' :?0}")
	List<ChatOpenForumModal> findByCourseId(Long courseId);

	@Query("{'commentId' :?0}")
	Optional<ChatOpenForumModal> findByCommentId(Long commentId);

	@Query(value = "{'commentId' : ?0}", delete = true)
	void deleteByCommentId(Long commentId);
}
