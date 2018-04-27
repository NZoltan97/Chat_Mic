package com.ticketninja.pilot.services.IMainService.IMainServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.exceptions.CheckSumException;
import com.ticketninja.pilot.exceptions.CommentException;
import com.ticketninja.pilot.exceptions.EmailNotFoundException;
import com.ticketninja.pilot.exceptions.HNumberException;
import com.ticketninja.pilot.exceptions.NameException;
import com.ticketninja.pilot.exceptions.OrgNameException;
import com.ticketninja.pilot.exceptions.SettlementException;
import com.ticketninja.pilot.exceptions.StreetException;
import com.ticketninja.pilot.exceptions.ZipCodeException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;
import com.ticketninja.pilot.services.EmailService.impl.EmailServiceImpl;
import com.ticketninja.pilot.services.IMainService.IMainService;
import com.ticketninja.pilot.util.StatusCode;
import com.ticketninja.pilot.validator.IValidator;
import com.ticketninja.pilot.validator.impl.ValidatorImpl;


@Service
public class IMainServiceImpl implements IMainService {

	private static final Logger LOGGER = Logger.getLogger(IMainServiceImpl.class.getName());

	@Autowired
	private UserInfoDAOImpl userDao;

	private AttributeDTO attDto=new AttributeDTO();
	
	private IValidator validator=new ValidatorImpl();

	// Service methods

	public ResponseEntity<AttributeDTO> giveWholeInfo(String organizationName, String settlement, String contName,
			String mail, String street, String houseNumber, String zipCode, String isCorrect) {
		UserInfo uInfo = new UserInfo(organizationName, settlement, contName, mail, street, houseNumber, zipCode);
		userDao.saveUser(uInfo);
		isCorrect=StatusCode.OK;
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganizationName(String orgName, String mail, String isCorrect) {
		
		try {
			
			// isCorrect kiszervezése
			validator.validateOrgName(orgName);
			userDao.setOrgName(orgName, mail);
			isCorrect = StatusCode.OK;
		} catch (OrgNameException e) {
			isCorrect = e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersZipCode(String zipCode, String mail, String isCorrect) {
		try {
			validator.validateZip(zipCode);
			userDao.setZipCode(zipCode, mail);
			isCorrect = StatusCode.OK;
		} catch (ZipCodeException e) {
			isCorrect=e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		}finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersSettlement(String settlement, String mail, String isCorrect) {
		try {
			validator.validateSettlement(settlement);
			userDao.setOrgSettlement(settlement, mail);
			isCorrect = StatusCode.OK;
		} catch (SettlementException e) {
			isCorrect = e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersStreet(String street, String mail, String isCorrect) {
		try {
			validator.validateStreet(street);
			userDao.setOrgStreet(street, mail);
			isCorrect = StatusCode.OK;
		} catch (StreetException e) {
			isCorrect = e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveOrganisersHouseNumber(String houseNum, String mail, String isCorrect) {
		try {
			validator.validateHnumber(houseNum);
			userDao.setHouseNum(houseNum, mail);
			isCorrect = StatusCode.OK;
		} catch (HNumberException e) {
			isCorrect = e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveContactName(String fullName, String mail, String isCorrect) {
		try {
			validator.validateName(fullName);
			userDao.setContName(fullName, mail);
			isCorrect = StatusCode.OK;
		} catch (NameException e) {
			isCorrect = e.getException();
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> giveContactsComment(String comment, String mail, String isCorrect) {
		try {
			validator.validateComment(comment);			
			userDao.setComment(comment, mail);
			isCorrect = StatusCode.OK;
		}catch(CommentException e) {
			isCorrect=e.getException();
		}catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> validateCheckSum(String checkSumFromUser, String mail, String isCorrect) {
		try {
			UserInfo user = userDao.getUserByEmail(mail);
			validator.validateCheckSum(checkSumFromUser, user);
			user.setValid(true);
			userDao.saveUser(user);
			isCorrect = StatusCode.OK;
		} catch (EmailNotFoundException e) {
			LOGGER.log(Level.ALL, e.getException(), e);
		} catch (CheckSumException e) {
			isCorrect = e.getException();
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> sendingMail(String mail, String isCorrect) {
		try {
			userDao.getUserByEmail(mail);
			isCorrect = StatusCode.ALREADYFOUNDMAILADDRESS;
		} catch (EmailNotFoundException e) {
			try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml")) {
				EmailServiceImpl m = (EmailServiceImpl) context.getBean("mailService");
				UserInfo uInfo = new UserInfo(mail);
				userDao.saveUser(uInfo);
			
				m.sendMail(uInfo.getMail(), uInfo.getCheckS());
				isCorrect = StatusCode.OK;
			}
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	// In progress
	public ResponseEntity<AttributeDTO> sendingMimeMail(String mail, String isCorrect) {
		try {
			userDao.getUserByEmail(mail);
			isCorrect = StatusCode.ALREADYFOUNDMAILADDRESS;
		} catch (EmailNotFoundException e) {
			try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml")) {
				EmailServiceImpl m = (EmailServiceImpl) context.getBean("mailService");
				UserInfo uInfo = new UserInfo(mail);
				userDao.saveUser(uInfo);
				m.sendMail(uInfo.getMail(), uInfo.getCheckS());
				isCorrect = StatusCode.OK;
			}
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getMessage(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}

		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);

	}
}
