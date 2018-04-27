package com.ticketninja.pilot.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketninja.pilot.exceptions.EmailNotFoundException;
import com.ticketninja.pilot.exceptions.UserIDNotFoundException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.repository.IUserInfoDAO;
import com.ticketninja.pilot.services.IMainService.IMainServiceImpl.IMainServiceImpl;


public class UserInfoDAOImpl {

	private static final Logger LOGGER = Logger.getLogger(IMainServiceImpl.class.getName());
	
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
	public void delete(String mail) throws EmailNotFoundException {
		UserInfo user=getUserByEmail(mail);
		try {
			userDao.delete(user);
		}catch (Exception e) {
			LOGGER.log(Level.ALL, e.toString(), e);
		}
	}

	// Find by the mail address
	public UserInfo getUserByEmail(String email)throws EmailNotFoundException{
		UserInfo user = new UserInfo();
		user = userDao.findByMail(email);
		if(user==null) {
			throw new EmailNotFoundException();
		} 
		return user;
	}

	// Find by id
	public UserInfo getUserByID(Long id) throws UserIDNotFoundException{
		UserInfo user = new UserInfo();
		user = userDao.findById(id).get();
		if(user==null) {
			throw new UserIDNotFoundException();
		} 
		return user;
	}

	// Update one user in the database
	public void setMail(String oldMail, String newMail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(oldMail);	
			userFromDB.setMail(newMail);
			saveUser(userFromDB);
	}

	public void setOrgName(String orgName, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);
			userFromDB.setOrgName(orgName);
			saveUser(userFromDB);
	}

	public void setOrgSettlement(String orgSettlement, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);
			userFromDB.setOrgSettlement(orgSettlement);
			saveUser(userFromDB);
	}

	public void setContName(String contName, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setContName(contName);
		saveUser(userFromDB);
	}

	public void setOrgStreet(String orgStreet, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);			
			userFromDB.setOrgStreet(orgStreet);
			saveUser(userFromDB);
	}

	public void setHouseNum(String houseNum, String mail) throws EmailNotFoundException  {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setHouseNum(houseNum);
		saveUser(userFromDB);
	}

	public void setZipCode(String zipCode, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);
		userFromDB.setZipCode(zipCode);
		saveUser(userFromDB);
	}
	
	public void setComment(String comment, String mail) throws EmailNotFoundException {
		UserInfo userFromDB = getUserByEmail(mail);
			userFromDB.setComment(comment);
			saveUser(userFromDB);
		}
}
