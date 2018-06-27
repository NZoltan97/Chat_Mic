package com.ticketninja.pilot.model;

import com.sendgrid.SendGrid;

public final class SendGridMailContent {
	public static SendGrid.Email sendGridMailContent;
	
	public static SendGrid.Email sendGridInit() {
		sendGridMailContent = new SendGrid.Email();
		sendGridMailContent.setFrom("uniteamsze@gmail.com");
		sendGridMailContent.setFromName("UniTeam");
		sendGridMailContent.setText(" ");
		sendGridMailContent.setHtml(" ");
		return sendGridMailContent;
		
	}

	
}
