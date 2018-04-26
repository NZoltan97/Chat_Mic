package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class OrgNameException extends ValidatorException {

	public String getException() {
		return StatusCode.INVALIDORGNAME;
	}
}
