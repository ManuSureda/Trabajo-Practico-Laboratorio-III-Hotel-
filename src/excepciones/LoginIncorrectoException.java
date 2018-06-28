package excepciones;

public class LoginIncorrectoException extends Exception{

	private String informacion;
	public LoginIncorrectoException(String info) {
		super(info);
		informacion=info;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return informacion;
	}
}
