package com.ticketninja.pilot.services.EmailService.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.dtos.MailValidationDTO;
import com.ticketninja.pilot.model.MailContent;
import com.ticketninja.pilot.model.MailContentFactory;
import com.ticketninja.pilot.services.EmailService.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	private MailContent content;
	private MailContentFactory factory=new MailContentFactory();
	
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
	
    public void sendMail(MailValidationDTO mailDto) {
    	
    	content=factory.createVerificationMailContent(mailDto);
    	mailSender.send(content.getSimpleMailMessage());  
    }
    
    
    
   /* public void sendHtmlEmail(String to, String msg) {
    	String html="";
    	MimeMessage message = mailSender.createMimeMessage();
    	try {
    	// use the true flag to indicate you need a multipart message
    	MimeMessageHelper helper = new MimeMessageHelper(message, true);
    	helper.setTo(to);
    	helper.setFrom("vkbubu1@gmail.com");
    	helper.setSubject("Verifying your email");
    	// use the true flag to indicate the text included is HTML
    	helper.setText(html, true);        
        this.mailSender.send(message);
    	}catch(Exception ex) {
    		Logger.getLogger(EmailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }   */
}