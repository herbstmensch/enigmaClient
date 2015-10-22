package de.herbstmensch.enigma.api.exceptions;


/**
 * @author Tim
 *
 * EnigmaException is thrown when request to webinterface returned error instead of result
 */
public class EnigmaException extends Exception {

	private static final long serialVersionUID = -6286680069838889042L;

	public EnigmaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EnigmaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EnigmaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
