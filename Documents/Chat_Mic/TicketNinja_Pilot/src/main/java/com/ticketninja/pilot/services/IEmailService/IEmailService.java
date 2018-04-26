package com.ticketninja.pilot.services.IEmailService;


public interface IEmailService {
	public void sendMail(String to, String msg);
	public void sendHtmlEmail(String to, String msg);
}
