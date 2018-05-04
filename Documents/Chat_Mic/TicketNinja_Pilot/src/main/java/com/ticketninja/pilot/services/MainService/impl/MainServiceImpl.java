package com.ticketninja.pilot.services.MainService.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.dtos.MailValidationDTO;
import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;
import com.ticketninja.pilot.services.EmailService.impl.EmailServiceImpl;
import com.ticketninja.pilot.services.MainService.IMainService;
import com.ticketninja.pilot.util.Status;
import com.ticketninja.pilot.validator.IValidator;
import com.ticketninja.pilot.validator.impl.ValidatorImpl;

@Service
public class MainServiceImpl implements IMainService {

	private static final Logger LOGGER = Logger.getLogger(MainServiceImpl.class.getName());
	
	@Autowired
	private UserInfoDAOImpl userDao;

	@Autowired
	private EmailServiceImpl mailService;
	
	private AttributeDTO attDto = new AttributeDTO();

	private IValidator validator = new ValidatorImpl();

	// Service methods

	public ResponseEntity<AttributeDTO> saveWholeInfo(InnerDTO innerDto) {
		int isCorrect;
		UserInfo uInfo = new UserInfo(innerDto.getOrgName(), innerDto.getOrgSettlement(), innerDto.getContName(), innerDto.getMail(),
				innerDto.getOrgStreet(), innerDto.getHouseNum(), innerDto.getZipCode(), innerDto.getCheckS());
		userDao.saveUser(uInfo);
		isCorrect = Status.OK.code();
		attDto.addAttribute(isCorrect);
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveOrganizationName(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateOrgName(innerDto.getOrgName());
			userDao.setOrgName(innerDto.getOrgName(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveOrganisersZipCode(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateZip(innerDto.getZipCode());
			userDao.setZipCode(innerDto.getZipCode(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveOrganisersSettlement(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateSettlement(innerDto.getOrgSettlement());
			userDao.setOrgSettlement(innerDto.getOrgSettlement(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveOrganisersStreet(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateStreet(innerDto.getOrgStreet());
			userDao.setOrgStreet(innerDto.getOrgStreet(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveOrganisersHouseNumber(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateHnumber(innerDto.getHouseNum());
			userDao.setHouseNum(innerDto.getHouseNum(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveContactName(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateName(innerDto.getContName());
			userDao.setContName(innerDto.getContName(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveContactsComment(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateComment(innerDto.getComment());
			userDao.setComment(innerDto.getComment(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> validateCheckSum(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			UserInfo user = userDao.getUserByEmail(innerDto.getMail());
			validator.validateCheckSum(innerDto.getCheckS(), user);
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

	public ResponseEntity<AttributeDTO> validateMailAddress(MailValidationDTO mailDto) {
		int isCorrect=0;
		try {
			userDao.getUserByEmail(mailDto.getTo());
			isCorrect = Status.ALREADYFOUNDMAILADDRESS.code();
		} catch (ValidatorException e) {
			UserInfo user = new UserInfo(mailDto.getTo(), mailDto.getCheckSum());
			userDao.saveUser(user);
				mailService.sendMail(mailDto);
				isCorrect=Status.OK.code();
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	// In progress
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
