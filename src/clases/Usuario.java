package clases;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.FechaInvalidaException;
import excepciones.IdNotFoundException;

public class Usuario extends Persona{

	private String nombreUsuario;
	private String password;
	
	
	public Usuario(String nombreCompletoParam, String dniParam, String telefonoParam, String domicilioParam) {
		super(nombreCompletoParam, dniParam, telefonoParam, domicilioParam);
	}
	
	public Usuario(String nombreCompleto, String dni, String telefono, String domicilio, String nombreUsuarioParam, String passwordParam) {
		super(nombreCompleto, dni, telefono, domicilio);
		nombreUsuario = nombreUsuarioParam;
		password = passwordParam;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}
	
//	+ reservar
	public void reservar(double costo, Fechas fechasDeOcupacion, ArrayList<Integer> habitaciones)
	{
		Reserva reserva = new Reserva(costo,habitaciones,fechasDeOcupacion);
		BaseDeDatos.agregarReserva(reserva.getId(), reserva);
	}
	
//	+ cancelarReserva
	public void cancelarReserva(int idReserva)
	{
		if (BaseDeDatos.getReservas().containsKey(idReserva))
		{
			Reserva aux=BaseDeDatos.getReservas().get(idReserva);
			boolean rta=false;
			Habitacion hab;
			for (Integer i : aux.getHabitacionesRequeridas())
			{
				hab=BaseDeDatos.getBaseHabitaciones().get(i);
				rta=hab.eliminarFecha(aux.getFechasOcupadas());
				if (!rta)
				{//esto no tiene sentido que pase, me parece
					throw new FechaInvalidaException("Fechas invalidas");
				}
			}
			BaseDeDatos.eliminarReserva(idReserva);
		}
		else
		{
			throw new IdNotFoundException("id incorrecta");
		}
	}
	
//	+ listarHabitaciones() 
	public void listarHabitaciones() 
	{
		BaseDeDatos.listarHabitaciones();
	}
//	+ verHabitacionesDisponibles()
	public void verHabitacionesDisponibles()
	{
		
	}
//	+ verHabitacionesNoDisponibles() 
	
}
