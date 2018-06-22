package com.ticketninja.pilot.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.ticketninja.pilot.dtos.MailValidationDTO;

public class SendGridMailService {
	
	private SendGrid sendGrid=new SendGrid("SCZOiZbJRvSacEo8o8ZkTQ");
	
	private Mail mail;
	
	private static final Logger LOGGER = Logger.getLogger(SendGridMailService.class.getName());
	
		/*public void activateTemplate() {
			Request request = new Request();
			try {
			  request.setMethod(Method.PATCH);
			  request.setEndpoint( "templates/7d77911a-2f11-478c-9d62-a01d432daa8b/versions/b88905e7-4b5c-436f-a3fd-611ee8cea4a8");
			  request.setBody("{\"active\": \"1\"}");
			  Response response = sendGrid.api(request);
			  System.out.println(response.getBody());
			}catch(IOException e) {
	    		LOGGER.log(Level.ALL, e.getMessage(), e);
	    	}
			
		}*/

	    public void buildSendgridMail(MailValidationDTO mailDto) {
	    	mail=new Mail();
			Email from= new Email();
			from.setEmail("uniteamsze@gmail.com");
			from.setName("UniTeam");
			mail.setFrom(from);
			mail.setSubject(mailDto.getSubject());
			mail.setTemplateId("7d77911a-2f11-478c-9d62-a01d432daa8b");
			Email to=new Email();
			to.setEmail(mailDto.getTo());
			to.setName("Random");
			Personalization pers=new Personalization();
			pers.addTo(to);
			pers.addSubstitution("<%body%>", "Sikeres küldés történt.");
			mail.addPersonalization(pers);
			
	    }
	    
	    public void sendgridEmailSending(){
	    	try {
	    		Request request = new Request();
	            request.setMethod(Method.POST);
	            request.setEndpoint("templates/7d77911a-2f11-478c-9d62-a01d432daa8b/versions/b88905e7-4b5c-436f-a3fd-611ee8cea4a8");
	            System.out.println(mail.build());
	            request.setBody(mail.build());
	            Response response=sendGrid.api(request);
	            System.out.println(response.getBody());
	    	}catch(IOException e) {
	    		LOGGER.log(Level.ALL, e.getMessage(), e);
	    	}
		       
	    }
}
