package com.stackroute.chatservice.modal;

import java.io.Serializable;

public class ReplierModal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String replyAdded;

	public String getReplyAdded() {
		return replyAdded;
	}

	public void setReplyAdded(String replyAdded) {
		this.replyAdded = replyAdded;
	}

	public ReplierModal() {
		super();
	}

	public ReplierModal(String replyAdded) {
		super();
		this.replyAdded = replyAdded;
	}

}
