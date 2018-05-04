package com.ticketninja.pilot.model;

import com.ticketninja.pilot.dtos.MailValidationDTO;

public class MailContentFactory {

	public MailContent createVerificationMailContent(MailValidationDTO dto) {
		MailContent content=new MailContent();
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		return content;
	}	
}
