package com.ticketninja.pilot.model;

import java.util.Map;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class VerificationMailContent {

	private String to;
	private String from="uniteamsze@gmail.com";
	private String subject;
	private Map<String, Object> parameters;

	protected String getTo() {
		return to;
	}

	protected void setTo(String to) {
		this.to = to;
	}

	protected String getFrom() {
		return from;
	}

	protected void setFrom(String from) {
		this.from = from;
	}

	protected String getSubject() {
		return subject;
	}

	protected void setSubject(String subject) {
		this.subject = subject;
	}

	protected Map<String, Object> getAllParameters() {
		return parameters;
	}

	protected void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	protected Object getParameter(String key) {
		return parameters.get(key);
	}

	public SimpleMailMessage getSimpleMailMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		for (Map.Entry<String, Object> e : parameters.entrySet()) {
			message.setText(e.getValue().toString());
		}
		return message;
	}

}
