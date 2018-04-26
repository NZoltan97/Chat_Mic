package com.ticketninja.pilot.exceptions.ValidatorExceptions.UserAttributeExceptions;

import com.ticketninja.pilot.exceptions.ValidatorExceptions.ValidatorException;
import com.ticketninja.pilot.util.StatusCode;

public class NameException extends ValidatorException {
	
	private static final long serialVersionUID = 1L;
	
	public String getException() {
		return StatusCode.INVALIDNAME;
	}
	
}
