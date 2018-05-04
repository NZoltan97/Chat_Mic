package com.ticketninja.pilot.model;

import com.ticketninja.pilot.dtos.MailValidationDTO;

public class MailContentFactory {

	public VerificationMailContent createVerificationMailContent(MailValidationDTO dto) {
		VerificationMailContent content=new VerificationMailContent();
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		return content;
	}	
}
