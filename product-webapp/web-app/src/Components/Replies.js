import React, { useState } from "react";
import Modal from "./Modal";
import deleteIcon from "./images/icon-delete.svg"
import editIcon from "./images/icon-edit.svg"
import replyIcon from "./images/icon-reply.svg"


const Replies = ({
  reply,
  currentUser,
  onEditHandler,
  onDeleteHandler,
  replies,
  setReplies,
  showModal,
  onClickModalDelete,
  onClickModalCancel,
}) => {
  const [showInnerReply, setShowInnerReply] = useState(false);
  const [contentReplyValue, setContentReplyValue] = useState(
    `@${reply.user.username}`
  );
  let [score, setScore] = useState(reply.score);
  const [btnUpDisabled, setBtnUpDisabled] = useState(false);
  const [btnDownDisabled, setBtnDownDisabled] = useState(false);

  const onClickReplyHandler = (id) => {
    //show the reply block
    setShowInnerReply(true);
  };
  const onClickSendHandler = (id) => {
    //remove the showreply false
    let newReply = {
      id: new Date().getTime().toString(),
      content: `${contentReplyValue}`,
      createdAt: new Date().toISOString(),
      score: 2,
      replyingTo: `${reply.user.username}`,
      user: {
        image: {
          png: `${currentUser.image.png}`,
        },
        username: `${currentUser.username}`,
      },
    };

    //Add it to the reply of corresponding comment to the replies array
    setReplies([...replies, newReply]);
    setShowInnerReply(false);
  };
  let starterScore = reply.score;

  return (
    <>
      <div className="comments">
        <div className="user__profile">
          <div className="user__info">
            <div className="user-details">
              {/* <img
                className="user__img"
                src={reply.user.image.png}
                alt={reply.user.username}
              /> */}
              <h4>{reply.user.username} </h4>
              {currentUser.username === reply.user.username && (
                <h4 className="you-text">You</h4>
              )}
              <p>{reply.createdAt} </p>
            </div>
            <div className="user__btns">
              {currentUser.username === reply.user.username ? (
                <div className="change-btns">
                  <span onClick={() => onDeleteHandler(reply.id)}>
                    <img src={deleteIcon} alt="icon-delete" />{" "}
                    Delete
                  </span>
                  <span onClick={() => onEditHandler(reply.id)}>
                    <img src={editIcon} alt="icon-edit" /> Edit
                  </span>
                </div>
              ) : (
                <div
                  className="reply"
                  onClick={() => onClickReplyHandler(reply.id)}
                >
                  <img
                    className="reply-icon"
                    src={replyIcon}
                    alt="icon-reply"
                  />
                  <h5>Reply</h5>{" "}
                </div>
              )}
            </div>
          </div>
          <div className="user__desc">
            <p>{reply.content}</p>
          </div>
        </div>
      </div>
      {showInnerReply && (
        <div className="type__comments">
          {/* <img
            className="current__user"
            src="./images/avatars/image-juliusomo.png"
            alt="juliusomo"
          /> */}
          <textarea
            name=""
            id=""
            value={contentReplyValue}
            onChange={(e) => setContentReplyValue(e.target.value)}
          ></textarea>
          <button
            className="btn btn-send"
            onClick={() => onClickSendHandler(reply.id)}
          >
            SEND
          </button>
        </div>
      )}
      {showModal && (
        <Modal
          onClickModalDelete={onClickModalDelete}
          onClickModalCancel={onClickModalCancel}
        />
      )}
    </>
  );
};

export default Replies;
