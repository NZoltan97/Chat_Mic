package com.ticketninja.pilot.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeDTO {

	@JsonProperty("set_attributes")
	private AttributeName name;
	
	public AttributeDTO() {
		
	}

	public AttributeName getName() {
		return name;
	}

	public void addAttribute(String value) {
		this.name = new AttributeName(value);
		
	}

}
