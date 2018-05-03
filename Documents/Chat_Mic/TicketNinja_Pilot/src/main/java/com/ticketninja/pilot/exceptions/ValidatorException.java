package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.Status;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	protected Status status;
	
	public Status getStatus() {
		return this.status;
	}
	
	public ValidatorException(Status status) {
		super();
		this.status = status;
	}
}
