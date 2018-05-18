package com.ticketninja.pilot.validator;

import com.ticketninja.pilot.exceptions.ValidatorException;
import com.ticketninja.pilot.model.UserInfo;

public interface IValidator {

	public void validateCheckSum(String checkSumFromUser, UserInfo user) throws ValidatorException;
	public void validateOrgName(String s) throws ValidatorException;
	public void validateZip(String s) throws ValidatorException;
	public void validateSettlement(String s) throws ValidatorException;
	public void validateStreet(String s) throws ValidatorException;
	public void validateHnumber(String s) throws ValidatorException;
	public void validateName(String s) throws ValidatorException;
	public void validateComment(String comment) throws ValidatorException;
	public void validateEventName(String s) throws ValidatorException;
	public void validateDate(String date) throws ValidatorException;
}
