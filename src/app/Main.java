package app;

import clases.BaseDeDatos;
import clases.Habitacion;
import usuario.Cliente;
import usuario.Usuario;
import clases.Habitacion;


public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		Habitacion a=new Habitacion(4,1500,1);
		Habitacion b=new Habitacion(4,1700,2);
		Cliente aux=new Cliente("Maxi","1","1","1","max","max");
		BaseDeDatos.agregarHabitacion(1,a);
		BaseDeDatos.agregarHabitacion(2,b);
		aux.HacerReserva();
		BaseDeDatos.verTodasLasReservas();

	}

}
