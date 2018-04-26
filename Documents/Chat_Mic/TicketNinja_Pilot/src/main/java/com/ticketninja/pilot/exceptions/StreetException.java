package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class StreetException extends ValidatorException {

	public String getException() {
		return StatusCode.INVALIDSTREET;
	}
}
