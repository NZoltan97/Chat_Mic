package com.ticketninja.pilot.dtos;

import java.util.Map;

public class MailDTO {

	private String to;
	private String from="uniteamsze@gmail.com";
	private String subject;
	private Map<String, Object> parameters;
	
	public MailDTO(String to, String subject, String key, Object value) {
		this.to = to;
		this.subject = subject;
		addParameter(key,value);
	}
	
	public MailDTO() {};
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void addParameters( Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}
	
	
}
