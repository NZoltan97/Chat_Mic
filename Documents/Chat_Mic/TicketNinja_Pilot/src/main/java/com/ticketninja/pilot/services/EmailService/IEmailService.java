package com.ticketninja.pilot.services.EmailService;

import com.ticketninja.pilot.dtos.MailDTO;

public interface IEmailService {
	
	public void sendMail(MailDTO dto);
	//public void sendHtmlEmail(String to, String msg);
}
