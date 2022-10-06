package com.stackroute.userservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ERole {
	@JsonProperty("admin")
	ADMIN, 
	@JsonProperty("learner")
	LEARNER, 
	@JsonProperty("mentor")
	MENTOR;
}
