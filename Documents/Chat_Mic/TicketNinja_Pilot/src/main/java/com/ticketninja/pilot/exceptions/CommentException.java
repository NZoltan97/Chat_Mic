package com.ticketninja.pilot.exceptions;

import com.ticketninja.pilot.util.StatusCode;

public class CommentException extends ValidatorException{

private static final long serialVersionUID = 1L;
	
	public String getException() {
		return StatusCode.INVALIDCOMMENT;
	}
}