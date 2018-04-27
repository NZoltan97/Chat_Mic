package com.ticketninja.pilot.validator.impl;

import org.springframework.web.util.HtmlUtils;

import com.ticketninja.pilot.exceptions.CheckSumException;
import com.ticketninja.pilot.exceptions.CommentException;
import com.ticketninja.pilot.exceptions.HNumberException;
import com.ticketninja.pilot.exceptions.MailException;
import com.ticketninja.pilot.exceptions.NameException;
import com.ticketninja.pilot.exceptions.OrgNameException;
import com.ticketninja.pilot.exceptions.SettlementException;
import com.ticketninja.pilot.exceptions.StreetException;
import com.ticketninja.pilot.exceptions.ZipCodeException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.validator.IValidator;

public class ValidatorImpl implements IValidator {

	public void validateCheckSum(String checkSumFromUser, UserInfo user) throws CheckSumException {
		if (user.getCheckS().compareTo(checkSumFromUser) != 0) {
			throw new CheckSumException();
		}
	}

	public void validateOrgName(String s) throws OrgNameException {
		if (!(!s.isEmpty() && (s.length() >= 5 && s.length() <= 150) && !isHtml(s))) {
			throw new OrgNameException();
		}
	}

	public void validateZip(String s) throws ZipCodeException {
		try {
			Integer.parseInt(s);
			if (s.length() != 4 || s.isEmpty()) {
				throw new ZipCodeException();
			}
		} catch (NumberFormatException e) {
			throw new ZipCodeException();
		}
	}

	public void validateSettlement(String s) throws SettlementException {
		if (!(!s.isEmpty() && (s.length() >= 5 && s.length() <= 50) && !isHtml(s))) {
			throw new SettlementException();
		}
	}

	public void validateStreet(String s) throws StreetException {
		if (!(!s.isEmpty() && (s.length() >= 5 && s.length() <= 50) && !isHtml(s))) {
			throw new StreetException();
		}
	}

	public void validateHnumber(String s) throws HNumberException {
		String r1 = "[1-9][0-9a-zA-Z/. -]+";
		String r2 = "[1-9]";

		if (!((s.matches(r1) && !isHtml(s)) || (s.matches(r2) && !isHtml(s)))) {
			throw new HNumberException();
		}
	}

	public void validateName(String s) throws NameException {
		if (!(!s.isEmpty() && (s.length() >= 3 && s.length() <= 12) && !isHtml(s))) {
			throw new NameException();
		}
	}

	public void validateComment(String comment) throws CommentException {
		if (comment.isEmpty() || comment.length() > 1000 || isHtml(comment)) {
			throw new CommentException();
		}
	}
	
	public void mailIsCleanFromXSS(String mail) throws MailException {
		if(mail==null || isHtml(mail)) {
			throw new MailException();
		}
	}

	// prevetion agains XSS attack
	// returns true if the string contains HTML characters
	private boolean isHtml(String input) {
		boolean isHtml = false;
		if (input != null) {
			if (!input.equals(HtmlUtils.htmlEscape(input))) {
				isHtml = true;
			}
		}
		return isHtml;
	}

}
