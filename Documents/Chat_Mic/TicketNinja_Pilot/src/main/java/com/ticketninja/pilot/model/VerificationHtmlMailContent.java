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
	private String cssContent;
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

	public String getCssContent() {
		return cssContent;
	}

	public void setCssContent(String cssContent) {
		this.cssContent = cssContent;
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
	
	public String addCssContent(Resource cssResource, String changeTokenCss) {
		StringBuilder sb = new StringBuilder();
		String temp = new String();
		try {
			BufferedReader cssFileContent=new BufferedReader(new InputStreamReader(cssResource.getInputStream()));
			while ((temp = cssFileContent.readLine()) != null) {
					sb.append(temp);
			}
			cssFileContent.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		cssContent = sb.toString();
		return cssContent;
	}

	public String createHtmlContent(Resource htmlResource, String changeTokenHtml, Resource cssResource, String changeTokenCss) {
		StringBuilder sb = new StringBuilder();
		String temp = new String();
		ArrayList<String> params=new ArrayList<String>();
		int paramIndex = 0;
		for (Map.Entry<String, Object> e : parameters.entrySet()) {
			params.add(e.getValue().toString());
		}
		try {
			BufferedReader htmlFileContent = new BufferedReader(new InputStreamReader(htmlResource.getInputStream()));
			while ((temp = htmlFileContent.readLine()) != null) {
				if (temp.contains(changeTokenCss)) {
					sb.append(addCssContent(cssResource, changeTokenCss));
				}else if(temp.contains(changeTokenHtml)) {
					sb.append(temp.replace(changeTokenHtml, params.get(paramIndex)));
				}
				else {
					sb.append(temp);
				}
			}
			htmlFileContent.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		htmlContent = sb.toString();
		return htmlContent;
	}
	public MimeMessage getMimeMessage(JavaMailSender mailSender, Resource logoResource, Resource backgroundResource) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);
		helper.setText(htmlContent, true);
		helper.addInline("ninjaLogo", logoResource);
		helper.addInline("ninjaBackground",backgroundResource);
		}catch(MessagingException e) {
			System.out.println("Hiba!");
		}
		return message;
	}

}
