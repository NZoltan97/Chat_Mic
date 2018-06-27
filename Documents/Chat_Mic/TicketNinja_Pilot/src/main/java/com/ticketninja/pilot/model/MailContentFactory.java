package com.ticketninja.pilot.model;

import com.sendgrid.SendGrid;
import com.ticketninja.pilot.dtos.MailDTO;

public class MailContentFactory {

	SendGrid.Email sendGridMailContent;

	public VerificationMailContent createVerificationMailContent(MailDTO dto) {
		VerificationMailContent content = new VerificationMailContent();
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		return content;
	}

	public VerificationHtmlMailContent createVerificationHtmlMailContent(MailDTO dto) {
		VerificationHtmlMailContent content = new VerificationHtmlMailContent();
		content.setSubject(dto.getSubject());
		content.setTo(dto.getTo());
		content.setParameters(dto.getParameters());
		content.createHtmlContent(dto.getHtmlResource(), dto.getChangeTokenHtml(), dto.getCssResource(),
				dto.getChangeTokenCss());
		return content;
	}

	// SendGrid builders
	public void buildTruncatedDetailsSendgridMail(MailDTO mailDto) {
		sendGridMailContent=SendGridMailContent.sendGridInit();
		sendGridMailContent.addTo(mailDto.getTo());
		if (mailDto.getUserInfo().getLang().compareTo("hun") == 0) {
			sendGridMailContent.addFilter("templates", "template_id", "4b8c8aed-16d0-4bb6-ac6b-ea3d86bb2f7a");
			sendGridMailContent.setSubject("Összegző e-mail");
		} else {
			sendGridMailContent.addFilter("templates", "template_id", "10cdc900-ad8c-480f-baaa-e6e3416c0325");
			sendGridMailContent.setSubject("Details");
		}
		sendGridMailContent.addSubstitution("-contName-", new String[] { mailDto.getUserInfo().getContName() });
		sendGridMailContent.addSubstitution("-eventName-", new String[] { mailDto.getUserInfo().getEventName() });
		sendGridMailContent.addSubstitution("-eventDate-", new String[] { mailDto.getUserInfo().getEventDate() });

	}

	public void buildVerificationSendgridMail(MailDTO mailDto) {
		sendGridMailContent=SendGridMailContent.sendGridInit();
		sendGridMailContent.addTo(mailDto.getTo());
		if (mailDto.getUserInfo().getLang().compareTo("hun") == 0) {
			sendGridMailContent.addFilter("templates", "template_id", "c57069d6-b9a8-42b3-aba4-7647a6167db6");
			sendGridMailContent.setSubject("E-mail verifikáció");
		} else {
			sendGridMailContent.addFilter("templates", "template_id", "1dcce943-c66b-4c1a-abbf-ece61a2df534");
			sendGridMailContent.setSubject("E-mail verification");
		}
		sendGridMailContent.addSubstitution("-verificationCode-", new String[] { "" + mailDto.getCheckSum() });
	}

	public void buildWholeDetailsSendGridMail(MailDTO mailDto) {
		sendGridMailContent=SendGridMailContent.sendGridInit();
		sendGridMailContent.addTo(mailDto.getTo());
		if (mailDto.getUserInfo().getLang().compareTo("hun") == 0) {
			sendGridMailContent.addFilter("templates", "template_id", "5b9c9caf-01c4-45cb-ad05-fca449d9cb4c");
			sendGridMailContent.setSubject("Összegző e-mail");
		} else {
			sendGridMailContent.addFilter("templates", "template_id", "82aeaf44-44ba-4c57-8ba6-60796156e23d");
			sendGridMailContent.setSubject("Details");
		}
		sendGridMailContent.addSubstitution("-contName-", new String[] { mailDto.getUserInfo().getContName() });
		sendGridMailContent.addSubstitution("-eventName-", new String[] { mailDto.getUserInfo().getEventName() });
		sendGridMailContent.addSubstitution("-eventDate-", new String[] { mailDto.getUserInfo().getEventDate() });
		sendGridMailContent.addSubstitution("-orgName-", new String[] { mailDto.getUserInfo().getOrgName() });
		sendGridMailContent.addSubstitution("-orgSettlement-", new String[] { mailDto.getUserInfo().getOrgSettlement() });
		sendGridMailContent.addSubstitution("-orgStreet-", new String[] { mailDto.getUserInfo().getOrgStreet() });
		sendGridMailContent.addSubstitution("-orgHouseNum-", new String[] { mailDto.getUserInfo().getOrgHouseNum() });
	}

	public SendGrid.Email getSendGridMailContent() {
		return sendGridMailContent;
	}
}
