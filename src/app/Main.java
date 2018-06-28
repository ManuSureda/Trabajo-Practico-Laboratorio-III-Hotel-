package app;

import clases.BaseDeDatos;
import clases.Habitacion;
import clases.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario aux = new Usuario("David Masud","41430128","2236167698","San Lorenzo 4645");
		Habitacion auxHabitacion = new Habitacion(4,1500,1);
		Habitacion auxHabitacion2 = new Habitacion(2,1000,2);
		
		
		BaseDeDatos.agregarHabitacion(1, auxHabitacion);
		BaseDeDatos.agregarHabitacion(2, auxHabitacion2);
		
		
		
		aux.HacerReserva();

	}

}
