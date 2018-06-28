package clases;

import java.util.ArrayList;

public class Cliente extends Usuario {

	ArrayList <Integer>numeroReservas=new ArrayList();
	
	public Cliente(String nombreCompleto, String dni, String telefono, String domicilio, String nombreUsuarioParam,
			String passwordParam) {
		super(nombreCompleto, dni, telefono, domicilio, nombreUsuarioParam, passwordParam);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Muesta las reservas a partir de los numeros de reserva que almacena un cliente.
	 */
	public void consultarReservas()
	{
		for(Integer a:numeroReservas)
		{
			BaseDeDatos.getReservas().get(a).mostrarReserva();
		}
	}
	
}
