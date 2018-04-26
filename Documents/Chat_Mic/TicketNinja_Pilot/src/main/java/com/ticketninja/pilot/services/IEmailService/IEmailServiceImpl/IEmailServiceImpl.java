package com.ticketninja.pilot.services.IEmailService.IEmailServiceImpl;



import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.services.IEmailService.IEmailService;

@Service
public class IEmailServiceImpl implements IEmailService{
	
	
	private JavaMailSender mailSender;
	
    
    
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void sendMail(String to, String msg) {  
        //creating message  
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom("uniteamsze@gmail.com");  
        message.setTo(to);  
        message.setSubject("Email verfikáció"); 
        message.setText(msg);  
        //sending message  
        mailSender.send(message);     
    }
    
    public void sendHtmlEmail(String to, String msg) {
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
    		Logger.getLogger(IEmailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }   
}