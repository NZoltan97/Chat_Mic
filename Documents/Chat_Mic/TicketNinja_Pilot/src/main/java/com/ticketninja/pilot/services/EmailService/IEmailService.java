package com.ticketninja.pilot.services.EmailService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.MailDTO;

public interface IEmailService {
	
	public void sendMail(MailDTO dto);
	public ResponseEntity<AttributeDTO> validateMailAddress(MailDTO mailDto);
	public ResponseEntity<AttributeDTO> validateHtmlMailAddress(MailDTO mailDto);
}
