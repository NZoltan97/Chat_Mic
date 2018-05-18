package com.ticketninja.pilot.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ticketninja.pilot.dtos.MailValidationDTO;
import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;

public class MailContentFactory {
	
	private static final Logger LOGGER = Logger.getLogger(UserInfoDAOImpl.class.getName());

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
		try {
		content.createHtmlContent(dto.getHtmlResource(), dto.getChangeTokenHtml(), dto.getCssResource(), dto.getChangeTokenCss());
		} catch (ValidatorException e) {
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		}
		return content;
	}
}
