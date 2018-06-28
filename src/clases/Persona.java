package clases;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombreCompleto;
	private String dni;
	private String telefono;
	private String domicilio;
	
	public Persona(String nombreCompletoParam, String dniParam, String telefonoParam, String domicilioParam) {
		nombreCompleto = nombreCompletoParam;
		dni = dniParam;
		telefono = telefonoParam;
		domicilio = domicilioParam;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	@Override
	public String toString() {
		return "Nombre: "+nombreCompleto+"Telefono: "+telefono+"Dni: "+dni+"Domicilio: "+domicilio;
	}


}
