package com.ticketninja.pilot.services.EmailService;

import com.ticketninja.pilot.dtos.MailValidationDTO;

public interface IEmailService {
	
	public void sendMail(MailValidationDTO dto);
	//public void sendHtmlEmail(String to, String msg);
}
