package app;

import clases.Administrador;
import clases.BaseDeDatos;

import clases.Cliente;
import clases.Habitacion;
import clases.Hotel;
import clases.Habitacion;
import clases.Usuario;


public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		 * Lectura de archivos para cargar la BaseDeDatos
		 */
		
		BaseDeDatos.leerUsuarios();
		BaseDeDatos.leerHabitaciones();
		BaseDeDatos.leerReserva();
		
		Hotel costaEsmeralda = new Hotel("Costa Esmeralda","Av. Constitucion 5566","2234889596");
		
		costaEsmeralda.MenuLogin();
		BaseDeDatos.archivarHabitaciones();
		BaseDeDatos.archivarReserva();
		BaseDeDatos.archivarUsuarios();
		
	}

}
