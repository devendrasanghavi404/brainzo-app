package com.stackroute.productservice.modal;

public class Learner {

	private String learnerEmailId;
	private String learnerName;
	
	public Learner() {
		super();
	}
	public Learner(String learnerEmailId, String learnerName) {
		super();
		this.learnerEmailId = learnerEmailId;
		this.learnerName = learnerName;
	}
	public String getLearnerEmailId() {
		return learnerEmailId;
	}
	public void setLearnerEmailId(String learnerEmailId) {
		this.learnerEmailId = learnerEmailId;
	}
	public String getLearnerName() {
		return learnerName;
	}
	public void setLearnerName(String learnerName) {
		this.learnerName = learnerName;
	}
	

}
