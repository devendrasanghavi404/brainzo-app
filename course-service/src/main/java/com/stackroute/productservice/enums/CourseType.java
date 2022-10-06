package com.stackroute.productservice.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CourseType {
	@JsonProperty("live")
	LIVE, @JsonProperty("recorded")
	RECORDED

}
