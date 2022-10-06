package com.stackroute.productservice.modal;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.stackroute.productservice.enums.CourseType;
@Document
public class Course {

	@Transient
	public static final String SEQUENCE_NAME = "course_sequence";

	@Id
	private long courseId;
	private String mentorEmailId;
	private String courseName;

	private Binary courseImage;
	private double courseFee;
	private String description;
	private List<CourseReview> courseReview;
	@Enumerated(EnumType.STRING)
	private CourseType courseType;
	private String language;
	private List<Learner> learner;
	
	public Course() {
		super();
	}
	public Course(long courseId, String mentorEmailId, String courseName, Binary courseImage, double courseFee,
			String description, List<CourseReview> courseReview, CourseType courseType, String language,
			List<Learner> learner) {
		super();
		this.courseId = courseId;
		this.mentorEmailId = mentorEmailId;
		this.courseName = courseName;
		this.courseImage = courseImage;
		this.courseFee = courseFee;
		this.description = description;
		this.courseReview = courseReview;
		this.courseType = courseType;
		this.language = language;
		this.learner = learner;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getMentorEmailId() {
		return mentorEmailId;
	}
	public void setMentorEmailId(String mentorEmailId) {
		this.mentorEmailId = mentorEmailId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Binary getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(Binary courseImage) {
		this.courseImage = courseImage;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CourseReview> getCourseReview() {
		return courseReview;
	}
	public void setCourseReview(List<CourseReview> courseReview) {
		this.courseReview = courseReview;
	}
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<Learner> getLearner() {
		return learner;
	}
	public void setLearner(List<Learner> learner) {
		this.learner = learner;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	

}
