package excepciones;

public class FechaInvalidaException extends RuntimeException{
	
	private String message;

	public FechaInvalidaException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
