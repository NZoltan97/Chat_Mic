package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class UserIDNotFoundException extends DAOException{
	private static final long serialVersionUID = 1L;
	
	public String getException() {
		return StatusCode.USERIDNOTFOUND;
	}
}
