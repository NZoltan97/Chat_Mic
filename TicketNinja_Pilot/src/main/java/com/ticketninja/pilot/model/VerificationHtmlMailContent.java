package com.ticketninja.pilot.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class VerificationHtmlMailContent {
	private String to;
	private String from = "uniteamsze@gmail.com";
	private String subject;
	private Map<String, Object> parameters;
	private String htmlContent;

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
	
	

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
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

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public String createHtmlContent(Resource resource, String changeToken) {
		StringBuilder sb = new StringBuilder();
		String temp = new String();
		ArrayList<String> params=new ArrayList<String>();
		int paramIndex = 0;
		for (Map.Entry<String, Object> e : parameters.entrySet()) {
			params.add(e.getValue().toString());
		}
		try {
			BufferedReader fileContent = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			while ((temp = fileContent.readLine()) != null) {
				if (temp.contains(changeToken)) {
					sb.append(temp.replace(changeToken, params.get(paramIndex)));
				} else {
					sb.append(temp);
				}
			}
			fileContent.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		htmlContent = sb.toString();
		return htmlContent;
	}
	public MimeMessage getMimeMessage(JavaMailSender mailSender) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);
		helper.setText(htmlContent, true);
		}catch(MessagingException e) {
			System.out.println("Hiba!");
		}
		return message;
	}

}
