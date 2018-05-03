package com.ticketninja.pilot.services.IMainService.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;
import com.ticketninja.pilot.services.EmailService.impl.EmailServiceImpl;
import com.ticketninja.pilot.services.IMainService.IMainService;
import com.ticketninja.pilot.util.Status;
import com.ticketninja.pilot.validator.IValidator;
import com.ticketninja.pilot.validator.impl.ValidatorImpl;

@Service
public class IMainServiceImpl implements IMainService {

	private static final Logger LOGGER = Logger.getLogger(IMainServiceImpl.class.getName());

	@Autowired
	private UserInfoDAOImpl userDao;

	private AttributeDTO attDto = new AttributeDTO();

	private IValidator validator = new ValidatorImpl();

	// Service methods

	public ResponseEntity<AttributeDTO> giveWholeInfo(String organizationName, String settlement, String contName,
			String mail, String street, String houseNumber, String zipCode) {
		int isCorrect;
		UserInfo uInfo = new UserInfo(organizationName, settlement, contName, mail, street, houseNumber, zipCode);
		userDao.saveUser(uInfo);
		isCorrect = Status.OK.code();
		attDto.addAttribute(isCorrect);
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganizationName(String orgName, String mail) {
		int isCorrect = 0;
		try {
			validator.validateOrgName(orgName);
			userDao.setOrgName(orgName, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(String zipCode, String mail) {
		int isCorrect = 0;
		try {
			validator.validateZip(zipCode);
			userDao.setZipCode(zipCode, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(String settlement, String mail) {
		int isCorrect = 0;
		try {
			validator.validateSettlement(settlement);
			userDao.setOrgSettlement(settlement, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersStreet(String street, String mail) {
		int isCorrect = 0;
		try {
			validator.validateStreet(street);
			userDao.setOrgStreet(street, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(String houseNum, String mail) {
		int isCorrect = 0;
		try {
			validator.validateHnumber(houseNum);
			userDao.setHouseNum(houseNum, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveContactName(String fullName, String mail) {
		int isCorrect = 0;
		try {
			validator.validateName(fullName);
			userDao.setContName(fullName, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveContactsComment(String comment, String mail) {
		int isCorrect = 0;
		try {
			validator.validateComment(comment);
			userDao.setComment(comment, mail);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> validateCheckSum(String checkSumFromUser, String mail) {
		int isCorrect = 0;
		try {
			UserInfo user = userDao.getUserByEmail(mail);
			validator.validateCheckSum(checkSumFromUser, user);
			user.setValid(true);
			userDao.saveUser(user);
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

//	public ResponseEntity<AttributeDTO> sendingMail(String mail) {
//		int isCorrect = 0;
//		try {
//			userDao.getUserByEmail(mail);
//			isCorrect = Status.ALREADYFOUNDMAILADDRESS.code();
//		} catch (ValidatorException e) {
//			try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml")) {
//				EmailServiceImpl m = (EmailServiceImpl) context.getBean("mailService");
//				UserInfo uInfo = new UserInfo(mail);
//				userDao.saveUser(uInfo);
//
//				m.sendMail(uInfo.getMail(), uInfo.getCheckS());
//				isCorrect = StatusCode.OK;
//			}
//		} catch (Exception e) {
//			LOGGER.log(Level.ALL, e.getMessage(), e);
//		} finally {
//			attDto.addAttribute(isCorrect);
//		}
//		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
//	}
//
//	// In progress
//	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect) {
//		try {
//			userDao.getUserByEmail(mail);
//			isCorrect = StatusCode.ALREADYFOUNDMAILADDRESS;
//		} catch (EmailNotFoundException e) {
//			try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml")) {
//				EmailServiceImpl m = (EmailServiceImpl) context.getBean("mailService");
//				UserInfo uInfo = new UserInfo(mail);
//				userDao.saveUser(uInfo);
//				m.sendMail(uInfo.getMail(), uInfo.getCheckS());
//				isCorrect = StatusCode.OK;
//			}
//		} catch (Exception e) {
//			LOGGER.log(Level.ALL, e.getMessage(), e);
//		} finally {
//			attDto.addAttribute(isCorrect);
//		}
//
//		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
//
//	}

}
