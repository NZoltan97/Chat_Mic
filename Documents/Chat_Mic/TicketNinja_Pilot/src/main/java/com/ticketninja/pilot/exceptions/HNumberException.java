package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class HNumberException extends ValidatorException {
	
	public String getException() {
		return StatusCode.INVALIDHNUMBER;
	}
}
