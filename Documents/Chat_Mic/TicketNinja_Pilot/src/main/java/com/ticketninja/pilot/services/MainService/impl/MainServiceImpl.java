package com.ticketninja.pilot.services.MainService.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.dtos.AttributeDTO;
import com.ticketninja.pilot.dtos.InnerDTO;
import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.impl.UserInfoDAOImpl;
import com.ticketninja.pilot.services.MainService.IMainService;
import com.ticketninja.pilot.util.Status;
import com.ticketninja.pilot.validator.IValidator;
import com.ticketninja.pilot.validator.impl.ValidatorImpl;

@Service
public class MainServiceImpl implements IMainService {

	private static final Logger LOGGER = Logger.getLogger(MainServiceImpl.class.getName());

	@Autowired
	private UserInfoDAOImpl userDao;

	private AttributeDTO attDto = new AttributeDTO();

	private IValidator validator = new ValidatorImpl();

	// Service methods
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
			validator.validateZip(innerDto.getOrgZipCode());
			userDao.setOrgZipCode(innerDto.getOrgZipCode(), innerDto.getMail());
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
			validator.validateHnumber(innerDto.getOrgHouseNum());
			userDao.setOrgHouseNum(innerDto.getOrgHouseNum(), innerDto.getMail());
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

	public ResponseEntity<AttributeDTO> saveEventName(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateEventName(innerDto.getEventName());
			userDao.setEventName(innerDto.getEventName(), innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> saveEventDate(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			validator.validateEventDate(innerDto.getEventDate());
			userDao.setEventDate(innerDto.getEventDate(), innerDto.getMail());
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
			validator.validateCheckSum(innerDto.getCheckSum(), user);
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

	public ResponseEntity<AttributeDTO> saveFeedback(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			UserInfo user = userDao.getUserByEmail(innerDto.getMail());
			user.setFeedback(innerDto.getFeedback());
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

	public ResponseEntity<AttributeDTO> deleteUser(InnerDTO innerDto) {
		int isCorrect = 0;
		try {
			userDao.delete(innerDto.getMail());
			isCorrect = Status.OK.code();
		} catch (ValidatorException e) {
			isCorrect = e.getStatus().code();
			LOGGER.log(Level.ALL, e.getStatus().description(), e);
		} finally {
			attDto.addAttribute(isCorrect);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<String> getFeedbacks() {
		int[] fb = new int[5];
		List<UserInfo> users = userDao.getAllUsers();
		for (int i = 0; i < users.size(); ++i) {
			UserInfo user = users.get(i);
			switch (user.getFeedback()) {
			case "1":
				fb[0] = fb[0] + 1;
				break;
			case "2":
				fb[1] = fb[1] + 1;
				break;
			case "3":
				fb[2] = fb[2] + 1;
				break;
			case "4":
				fb[3] = fb[3] + 1;
				break;
			case "5":
				fb[4] = fb[4] + 1;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Értékelések:");
		sb.append("\n");
		for (int i = 0; i < fb.length; i++) {
			sb.append(i + 1);
			sb.append(":");
			if(fb[i]!=0) {
				sb.append(""+fb[i]);
			}
		}
		return new ResponseEntity<String>(sb.toString(),HttpStatus.OK);
	}

}
