package com.ticketninja.pilot.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeDTO {

	@JsonProperty("set_attributes")
	private AttributeName name;
	

	public AttributeDTO() {
		
	}
	
	public void setName(AttributeName name) {
		this.name=name;
	}
	
	
	public AttributeName getName() {
		return name;
	}

	public void addAttribute(int value) {
		String stringValue = Integer.toString(value);
		this.name = new AttributeName(stringValue);
		
	}

}
