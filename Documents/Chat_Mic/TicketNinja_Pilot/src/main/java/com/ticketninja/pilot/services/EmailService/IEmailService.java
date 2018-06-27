package com.ticketninja.pilot.services.EmailService;

import org.springframework.http.ResponseEntity;

import com.sendgrid.SendGrid;
import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.MailDTO;

public interface IEmailService {
	
//	public void sendMail(MailDTO dto);
	public void sendGridMailSending(SendGrid.Email mail);
	public ResponseEntity<AttributeDTO> validateHtmlMailAddress(MailDTO mailDto);
	public ResponseEntity<AttributeDTO> sendTruncatedDetailsSendGridMail(MailDTO mailDto);
	public ResponseEntity<AttributeDTO> sendWholeDetailsSendGridMail(MailDTO mailDto);
}
