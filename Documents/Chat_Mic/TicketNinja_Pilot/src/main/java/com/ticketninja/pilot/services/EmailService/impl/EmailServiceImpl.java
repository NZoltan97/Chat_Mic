package com.ticketninja.pilot.services.EmailService.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.MailDTO;
import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.MailContentFactory;
import com.ticketninja.pilot.model.UserInfo;
//import com.ticketninja.pilot.model.VerificationHtmlMailContent;
//import com.ticketninja.pilot.model.VerificationMailContent;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;
import com.ticketninja.pilot.services.EmailService.IEmailService;
import com.ticketninja.pilot.util.Status;

@Service
public class EmailServiceImpl implements IEmailService {

//	@Autowired
//	private JavaMailSender mailSender;
//	private VerificationMailContent content;
//	private VerificationHtmlMailContent htmlContent;
	private MailContentFactory factory = new MailContentFactory();
	@Autowired
	UserInfoDAOImpl userDao;

	private AttributeDTO attDto = new AttributeDTO();

	private static final Logger LOGGER = Logger.getLogger(UserInfoDAOImpl.class.getName());

	private SendGrid sendGrid = new SendGrid("UniTeam", "Thecrew4");

	public void sendGridMailSending(SendGrid.Email mail) {
		try {
			SendGrid.Response response = sendGrid.send(mail);
			System.out.println(response.getMessage());
		} catch (SendGridException e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		}
	}

//	public void setMailSender(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}
//
//	public void sendMail(MailDTO mailDto) {
//
//		content = factory.createVerificationMailContent(mailDto);
//		mailSender.send(content.getSimpleMailMessage());
//	}
//
//	public void sendHtmlMail(MailDTO mailDto) {
//
//		htmlContent = factory.createVerificationHtmlMailContent(mailDto);
//		mailSender.send(
//				htmlContent.getMimeMessage(mailSender, mailDto.getLogoResource(), mailDto.getBackgroundResource()));
//	}

	public ResponseEntity<AttributeDTO> validateHtmlMailAddress(MailDTO mailDto) {
		int isCorrect = 0;
		try {
			userDao.getUserByEmail(mailDto.getTo());
			isCorrect = Status.ALREADYFOUNDMAILADDRESS.code();
		} catch (ValidatorException e) {
			UserInfo user = new UserInfo(mailDto.getTo(), mailDto.getCheckSum());
			user.setLang(mailDto.getLang());
			userDao.saveUser(user);
			//A MailContentFactory egységessége végett kell a mailDto-ba is menteni a usert.
			mailDto.setUserInfo(user);
			factory.buildVerificationSendgridMail(mailDto);
			sendGridMailSending(factory.getSendGridMailContent());
			isCorrect = Status.OK.code();
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> sendTruncatedDetailsSendGridMail(MailDTO mailDto) {
		int isCorrect = 0;
		try {
			mailDto.setUserInfo(userDao.getUserByEmail(mailDto.getTo()));
			factory.buildTruncatedDetailsSendgridMail(mailDto);
			sendGridMailSending(factory.getSendGridMailContent());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			UserInfo user = new UserInfo(mailDto.getTo(), mailDto.getCheckSum());
			userDao.saveUser(user);
			isCorrect = Status.MAILADDRESSNOTFOUND.code();
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}
	
	public ResponseEntity<AttributeDTO> sendWholeDetailsSendGridMail(MailDTO mailDto) {
		int isCorrect = 0;
		try {
			mailDto.setUserInfo(userDao.getUserByEmail(mailDto.getTo()));
			factory.buildWholeDetailsSendGridMail(mailDto);
			sendGridMailSending(factory.getSendGridMailContent());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			UserInfo user = new UserInfo(mailDto.getTo(), mailDto.getCheckSum());
			userDao.saveUser(user);
			isCorrect = Status.MAILADDRESSNOTFOUND.code();
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}
}