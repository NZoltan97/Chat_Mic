package com.ticketninja.pilot.exceptions.ValidatorExceptions;

import com.ticketninja.pilot.util.StatusCode;

public class CheckSumException extends ValidatorException {
	private static final long serialVersionUID = 1L;
	
	public String getException() {
		return StatusCode.INVALIDCHECKSUM;
	}
}
