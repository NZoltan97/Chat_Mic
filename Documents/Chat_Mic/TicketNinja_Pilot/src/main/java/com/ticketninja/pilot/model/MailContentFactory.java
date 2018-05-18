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
	
	public VerificationHtmlMailContent createVerificationHtmlMailContent(MailValidationDTO dto) {
		VerificationHtmlMailContent content=new VerificationHtmlMailContent();
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		content.createHtmlContent(dto.getHtmlResource(), dto.getChangeTokenHtml(), dto.getCssResource(), dto.getChangeTokenCss());
		return content;
	}
}
