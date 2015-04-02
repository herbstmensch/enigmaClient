package de.herbstmensch.enigma.api.exceptions;

public class APIException extends Exception {

	private static final long serialVersionUID = -6286680069838889042L;

	public APIException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public APIException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public APIException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
