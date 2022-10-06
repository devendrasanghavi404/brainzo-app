import axios from "axios";

export const fetchAllComment =  (courseId) => {
    return axios.get(`https://brainzo.stackroute.io/qna-service/api/v1/brainzo/qn/comment?courseId=${courseId}`);
}

export const updateComment = (commentId , data) => {
    return axios.put(`https://brainzo.stackroute.io/qna-service/api/v1/brainzo/qn/comment?commentId=${commentId}`, data);

}

export const deleteComment = (emailId , reply) => {
    return axios.delete(`https://brainzo.stackroute.io/qna-service/api/v1/brainzo/qn/delete?emaildId=${emailId}&reply=${reply}`);

}

export const getUser = (emailId) => {
    return axios.get(`https://brainzo.stackroute.io/user-service/api/brainzo/v1/${emailId}`);

}