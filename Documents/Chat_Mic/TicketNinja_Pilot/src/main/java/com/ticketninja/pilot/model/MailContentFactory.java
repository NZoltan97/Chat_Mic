package com.ticketninja.pilot.model;

import com.ticketninja.pilot.dtos.MailDTO;

public class MailContentFactory {

	public MailContent createVerificationMailContent(MailDTO dto) {
		MailContent content=new MailContent();
		content.setFrom(dto.getFrom());
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		return content;
	}	
}
