package clases;

public class Usuario extends Persona{

	private String nombreUsuario;
	private String password;
	private int typeUser;
	
	public Usuario(String nombreCompletoParam, String dniParam, String telefonoParam, String domicilioParam) {
		super(nombreCompletoParam, dniParam, telefonoParam, domicilioParam);
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombreCompleto, String dni, String telefono, String domicilio, String nombreUsuarioParam, String passwordParam, int typeUserParam) {
		super(nombreCompleto, dni, telefono, domicilio);
		nombreUsuario = nombreUsuarioParam;
		password = passwordParam;
		typeUser = typeUserParam;
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}
	
	

}
