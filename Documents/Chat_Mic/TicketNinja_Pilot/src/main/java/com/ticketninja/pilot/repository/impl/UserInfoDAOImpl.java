package com.ticketninja.pilot.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.IUserInfoDAO;
import com.ticketninja.pilot.util.Status;

@Service
public class UserInfoDAOImpl {

	private static final Logger LOGGER = Logger.getLogger(UserInfoDAOImpl.class.getName());

	@Autowired
	private IUserInfoDAO userDao;

	// The method that add a user to the database
	public void saveUser(UserInfo user) {
		try {
			userDao.save(user);
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.toString(), e);
		}
	}

	// Delete the user having the passed mail address.
	public void delete(String mail) throws ValidatorException {
		UserInfo user = getUserByEmail(mail);
		userDao.delete(user);
	}

	// Find by the mail address
	public UserInfo getUserByEmail(String email) throws ValidatorException {
		UserInfo user = new UserInfo();
		user = userDao.findByMail(email);
		if (user == null) {
			throw new ValidatorException(Status.MAILADDRESSNOTFOUND);
		}
		return user;
	}

	// Find by id
	public UserInfo getUserByID(Long id) throws ValidatorException {
		UserInfo user = new UserInfo();
		user = userDao.findById(id).get();
		if (user == null) {
			throw new ValidatorException(Status.USERIDNOTFOUND);
		}
		return user;
	}

	// Update one user in the database
	public void setMail(String oldMail, String newMail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(oldMail);
		userFromDB.setMail(newMail);
		saveUser(userFromDB);
	}

	public void setOrgName(String orgName, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setOrgName(orgName);
		saveUser(userFromDB);
	}

	public void setOrgSettlement(String orgSettlement, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setOrgSettlement(orgSettlement);
		saveUser(userFromDB);
	}

	public void setContName(String contName, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setContName(contName);
		saveUser(userFromDB);
	}

	public void setOrgStreet(String orgStreet, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setOrgStreet(orgStreet);
		saveUser(userFromDB);
	}

	public void setOrgHouseNum(String orgHouseNum, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setOrgHouseNum(orgHouseNum);
		saveUser(userFromDB);
	}

	public void setOrgZipCode(String orgZipCode, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setOrgZipCode(orgZipCode);
		saveUser(userFromDB);
	}
	
	public void setEventName(String eventName, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setEventName(eventName);
		saveUser(userFromDB);
	}
	
	public void setEventDate(String eventDate, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setEventDate(eventDate);
		saveUser(userFromDB);
	}

	public void setComment(String comment, String mail) throws ValidatorException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setComment(comment);
		saveUser(userFromDB);
	}
}
