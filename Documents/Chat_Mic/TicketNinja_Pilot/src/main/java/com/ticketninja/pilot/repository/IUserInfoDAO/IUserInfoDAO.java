package com.ticketninja.pilot.repository.IUserInfoDAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketninja.pilot.model.UserInfo;

@Transactional
public interface IUserInfoDAO extends JpaRepository<UserInfo, Long> {

	  /**
	   * This method will find an User instance in the database by its email.
	   * Note that this method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   */
	  public UserInfo findByMail(String mail);
}
