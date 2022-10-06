package com.stackroute.productservice.modal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class CourseReview {

	private String learnerEmailId;
	private String learnerReview;
	
	public CourseReview() {
		super();
	}
	public CourseReview(String learnerEmailId, String learnerReview) {
		super();
		this.learnerEmailId = learnerEmailId;
		this.learnerReview = learnerReview;
	}
	public String getLearnerEmailId() {
		return learnerEmailId;
	}
	public void setLearnerEmailId(String learnerEmailId) {
		this.learnerEmailId = learnerEmailId;
	}
	public String getLearnerReview() {
		return learnerReview;
	}
	public void setLearnerReview(String learnerReview) {
		this.learnerReview = learnerReview;
	}
	

}
