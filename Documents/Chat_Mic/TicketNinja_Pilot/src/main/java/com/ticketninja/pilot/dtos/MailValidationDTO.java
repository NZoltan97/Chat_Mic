package com.ticketninja.pilot.dtos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;

public class MailValidationDTO {

	private String to;
	private String subject;
	private int checkSum;
	private Map<String, Object> parameters;
	private Resource htmlResource;
	private String changeTokenHtml;
	private String changeTokenCss;
	private Resource logoResource;
	private Resource cssResource;
	private JavaMailSender mailSender;
	private Resource backgroundResource;
	
	public MailValidationDTO(String to, String subject) {
		this.to = to;
		this.subject = subject;
		parameters=new HashMap<String, Object>();
	}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}



	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}



	public Resource getBackgroundResource() {
		return backgroundResource;
	}



	public void setBackgroundResource(Resource backgroundResource) {
		this.backgroundResource = backgroundResource;
	}



	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}

	public Resource getHtmlResource() {
		return htmlResource;
	}

	public void setHtmlResource(Resource htmlResource) {
		this.htmlResource = htmlResource;
	}

	
	public Resource getCssResource() {
		return cssResource;
	}

	public void setCssResource(Resource cssResource) {
		this.cssResource = cssResource;
	}

	public Resource getLogoResource() {
		return logoResource;
	}

	public void setLogoResource(Resource logoResource) {
		this.logoResource = logoResource;
	}

	public String getChangeTokenHtml() {
		return changeTokenHtml;
	}

	public void setChangeTokenHtml(String changeTokenHtml) {
		this.changeTokenHtml = changeTokenHtml;
	}
	
	public String getChangeTokenCss() {
		return changeTokenCss;
	}

	public void setChangeTokenCss(String changeTokenCss) {
		this.changeTokenCss = changeTokenCss;
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
	public int getCheckSum() {
		return checkSum;
	}
	
	public int setCheckS() {
		Random rnd = new Random();
		this.checkSum = (rnd.nextInt(8999) + 1000);
		return (Integer)this.checkSum;
	}
	
	
}
