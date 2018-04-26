package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class NameException extends ValidatorException {
	
	public String getException() {
		return StatusCode.INVALIDNAME;
	}
	
}
