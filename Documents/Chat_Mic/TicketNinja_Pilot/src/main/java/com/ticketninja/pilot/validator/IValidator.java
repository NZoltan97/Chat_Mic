package com.ticketninja.pilot.validator;

import com.ticketninja.pilot.exceptions.CheckSumException;
import com.ticketninja.pilot.exceptions.CommentException;
import com.ticketninja.pilot.exceptions.HNumberException;
import com.ticketninja.pilot.exceptions.NameException;
import com.ticketninja.pilot.exceptions.OrgNameException;
import com.ticketninja.pilot.exceptions.SettlementException;
import com.ticketninja.pilot.exceptions.StreetException;
import com.ticketninja.pilot.exceptions.ZipCodeException;
import com.ticketninja.pilot.model.UserInfo;

public interface IValidator {

	public void validateCheckSum(String checkSumFromUser, UserInfo user) throws CheckSumException;
	public void validateOrgName(String s) throws OrgNameException;
	public void validateZip(String s) throws ZipCodeException;
	public void validateSettlement(String s) throws SettlementException;
	public void validateStreet(String s) throws StreetException;
	public void validateHnumber(String s) throws HNumberException;
	public void validateName(String s) throws NameException;
	public void validateComment(String comment) throws CommentException;
}
