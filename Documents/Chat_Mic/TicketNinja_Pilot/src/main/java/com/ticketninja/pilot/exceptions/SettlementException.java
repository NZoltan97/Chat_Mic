package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class SettlementException extends ValidatorException {
	
	public String getException() {
		return StatusCode.INVALIDSETTLEMENT;
	}
}
