package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class CheckSumException extends ValidatorException {
	
	public String getException() {
		return StatusCode.INVALIDCHECKSUM;
	}
}
