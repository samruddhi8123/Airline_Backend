package com.arp.lti.exception;

public class UserException extends ApplicationException{

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserException(String arg0) {
		super(arg0);
	}

	public UserException(Throwable arg0) {
		super(arg0);
	}
	
	

}
