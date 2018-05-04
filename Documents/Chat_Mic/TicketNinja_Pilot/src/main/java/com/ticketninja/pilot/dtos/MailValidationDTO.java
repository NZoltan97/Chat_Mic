package com.ticketninja.pilot.dtos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MailValidationDTO {

	private String to;
	private String subject;
	private String checkSum;
	private Map<String, Object> parameters;
	
	public MailValidationDTO(String to, String subject, String key) {
		this.to = to;
		this.subject = subject;
		parameters=new HashMap<String, Object>();
		addParameter(key,setCheckS());
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
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
	public String getCheckSum() {
		return checkSum;
	}
	
	private String setCheckS() {
		Random rnd = new Random();
		this.checkSum = "" + (rnd.nextInt(8999) + 1000);
		return this.checkSum;
	}
	
	
}
