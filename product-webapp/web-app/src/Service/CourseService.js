import axios from "axios";

export const fetchCourse = () => {
  return axios.get("https://brainzo.stackroute.io/course-service/brainzo/courses");
};

export const fetchCourseById = (courseId) => {
  return axios.get(`https://brainzo.stackroute.io/course-service/brainzo/courses/${courseId}`);
};

export const fetchContentByCourseId = (courseId) => {
  return axios.get(`https://brainzo.stackroute.io/content-service/brainzo/content/contents`);
}; 

export const addLearner = (data, courseId) => {
  return axios.put(`https://brainzo.stackroute.io/course-service/brainzo/courses/learner?courseId=${courseId}`, data);
};
export const fetchCourseByLearner = () => {
  return axios.get(`https://brainzo.stackroute.io/course-service/brainzo/courses/learnerEmailId/${localStorage.getItem("user")}`);
};
export const fetchCourseByMentor = () => {
  return axios.get(`https://brainzo.stackroute.io/course-service/brainzo/courses/mentorEmailId/${localStorage.getItem("user")}`);
};