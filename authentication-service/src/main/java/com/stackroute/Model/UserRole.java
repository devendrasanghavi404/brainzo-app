package com.stackroute.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {
	@JsonProperty("learner")
	LEARNER, 
	@JsonProperty("mentor")
	MENTOR;
}
