import React, { useEffect } from "react";
import { useState } from "react";
import './mycard.css';
import VideoModal from "./VideoModal";
import {Link,useNavigate} from "react-router-dom";

const MyCard = (props) => {
  const { courseImage,courseName,description,courseId, courseType} = props.item;

   const [openModal, setOpenModal] = useState(false);
   const [modal, setModal] = useState(true);
   const toggle = () => setModal(!modal);
   const role = localStorage.getItem('role');
   const navigate = useNavigate()
   
  return (
    <div className="single__course__item" >
      <div className="course_img img">
        <img src={`data:image/png;base64,${courseImage.data}`}
              alt="" className="w-100" />
      </div>

      <div className="course__details">
        <h4 className="course__title mb-4">{courseName}</h4>

        <div className=" d-flex justify-content-between align-items-center">
          <p>
         <b>Description : </b> {description}
          </p>
        </div> 
      </div>
       <div className="w-50 ">
          { role != "LEARNER" 
          ? <button className="btn" onClick={()=>{ 
            if( courseType === "recorded"){
              setOpenModal(true);
            }else {
              navigate("/meeting/nd5j-d0yu-3g25")
            }
           }}>{courseType === "recorded" ? "Add Session" : "Join Session"}</button> 
          : <Link to={ courseType === "recorded" ? "/courses/"+courseId+"/learning" : "/meeting/nd5j-d0yu-3g25"}> 
          <button className="btn" style={{'color':'white','textDecoration':'none'}}>
            {courseType === "recorded" ? "Start Learning" : "Join Session"}
            </button></Link> } 
            {/*learning page with id*/}
          {openModal && <VideoModal  handleChange={() => setOpenModal(false)} isModal={openModal} contentId={courseId} />}
        </div>
    </div>
  );
};

export default MyCard;