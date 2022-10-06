package com.stackroute.modal;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Payment {
	
	@Id
	private String orderId;
	private String paymentId;
	private String status;
	private String receipt;
	private String mentorEmailId;
	private String learnerEmailId;
	private long courseId;
	private String courseName;
	
	private double coursePrice;
	private Binary courseImage;
	
	
	public Payment() {
		super();
	}
	public Payment(String orderId, String paymentId, String status, String receipt, String mentorEmailId,
			String learnerEmailId, long courseId, String courseName, double coursePrice, Binary courseImage) {
		super();
		this.orderId = orderId;
		this.paymentId = paymentId;
		this.status = status;
		this.receipt = receipt;
		this.mentorEmailId = mentorEmailId;
		this.learnerEmailId = learnerEmailId;
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseImage = courseImage;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getMentorEmailId() {
		return mentorEmailId;
	}
	public void setMentorEmailId(String mentorEmailId) {
		this.mentorEmailId = mentorEmailId;
	}
	public String getLearnerEmailId() {
		return learnerEmailId;
	}
	public void setLearnerEmailId(String learnerEmailId) {
		this.learnerEmailId = learnerEmailId;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public Binary getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(Binary courseImage) {
		this.courseImage = courseImage;
	}
	
	

}
