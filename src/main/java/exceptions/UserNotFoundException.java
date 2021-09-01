package exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	private String message;
	
	public UserNotFoundException() {
		this.message = "User was not found";
	}
	public String getMessage() {
		return this.message;
	}
}