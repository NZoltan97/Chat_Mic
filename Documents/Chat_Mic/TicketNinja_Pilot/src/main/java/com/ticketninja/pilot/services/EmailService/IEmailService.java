package com.ticketninja.pilot.services.EmailService;

import org.springframework.http.ResponseEntity;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.MailValidationDTO;

public interface IEmailService {
	
	public void sendMail(MailValidationDTO dto);
	public ResponseEntity<AttributeDTO> validateMailAddress(MailValidationDTO mailDto);
	//public void sendHtmlEmail(String to, String msg);
}
