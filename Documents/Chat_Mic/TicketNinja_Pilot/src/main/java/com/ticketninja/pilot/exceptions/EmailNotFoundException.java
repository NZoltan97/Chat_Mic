package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class EmailNotFoundException extends ValidatorException {
	public String getException() {
		return StatusCode.MAILADDRESSNOTFOUND;
	}
}
