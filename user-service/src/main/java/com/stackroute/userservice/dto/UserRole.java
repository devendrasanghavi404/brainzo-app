package com.stackroute.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {
	@JsonProperty("admin")
	ADMIN, 
	@JsonProperty("learner")
	LEARNER, 
	@JsonProperty("mentor")
	MENTOR;
}