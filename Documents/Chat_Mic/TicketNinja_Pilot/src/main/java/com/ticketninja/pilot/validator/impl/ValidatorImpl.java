package com.ticketninja.pilot.validator.impl;

import org.springframework.web.util.HtmlUtils;

import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;
import com.ticketninja.pilot.util.Status;
import com.ticketninja.pilot.validator.IValidator;

public class ValidatorImpl implements IValidator {

	public void validateCheckSum(String checkSumFromUser, UserInfo user) throws ValidatorException {
		if (user.getCheckS().compareTo(checkSumFromUser) != 0) {
			throw new ValidatorException(Status.INVALIDCHECKSUM);
		}
	}

	public void validateOrgName(String s) throws ValidatorException {
		if (!(!s.isEmpty() || (s.length() >= 5 && s.length() <= 150) || !isHtml(s))) {
			throw new ValidatorException(Status.INVALIDORGNAME);
		}
	}
	
	public void validateZip(String s) throws ValidatorException {
		try {
			Integer.parseInt(s);
			if (s.length() != 4 || s.isEmpty()) {
				throw new ValidatorException(Status.INVALIDZIPCODE);
			}
		} catch (NumberFormatException e) {
			throw new ValidatorException(Status.INVALIDZIPCODE);
		}
	}

	public void validateSettlement(String s) throws ValidatorException {
		if (!(!s.isEmpty() || (s.length() >= 5 && s.length() <= 50) || !isHtml(s))) {
			throw new ValidatorException(Status.INVALIDSETTLEMENT);
		}
	}

	public void validateStreet(String s) throws ValidatorException {
		if (!(!s.isEmpty() || (s.length() >= 5 && s.length() <= 50) || !isHtml(s))) {
			throw new ValidatorException(Status.INVALIDSTREET);
		}
	}

	public void validateHnumber(String s) throws ValidatorException {
		String r1 = "[1-9][0-9a-zA-Z/. -]+";
		String r2 = "[1-9]";

		if (!((s.matches(r1) && !isHtml(s)) || (s.matches(r2) && !isHtml(s)))) {
			throw new ValidatorException(Status.INVALIDHNUMBER);
		}
	}

	public void validateName(String s) throws ValidatorException {
		if (!(!s.isEmpty() || (s.length() >= 3 && s.length() <= 12) || !isHtml(s))) {
			throw new ValidatorException(Status.INVALIDNAME);
		}
	}
	
	public void validateComment(String comment) throws ValidatorException {
		if(comment.isEmpty() || comment.length()>1000 || isHtml(comment)) {
			throw new ValidatorException(Status.INVALIDCOMMENT);
		}
	}

	public void mailIsCleanFromXSS(String mail) throws ValidatorException {
		if(mail==null || isHtml(mail)) {
			throw new ValidatorException(Status.INVALIDMAILCONTENT);
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
