package excepciones;

public class IdNotFoundException extends RuntimeException{
	private String mensaje;

	public IdNotFoundException(String mensaje) {
		
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	

}
