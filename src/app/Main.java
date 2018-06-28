package app;

import clases.BaseDeDatos;
<<<<<<< HEAD
import clases.Cliente;
import clases.Habitacion;
=======
import clases.Habitacion;
import clases.Usuario;
>>>>>>> 7620333990c345905a086cf9091143bb1ae766dc

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
		Habitacion a=new Habitacion(4,1500,1);
		Habitacion b=new Habitacion(4,1700,2);
		Cliente aux=new Cliente("Maxi","1","1","1","max","max");
		BaseDeDatos.agregarHabitacion(1,a);
		BaseDeDatos.agregarHabitacion(2,b);
		aux.HacerReserva();
=======
		
		Usuario aux = new Usuario("David Masud","41430128","2236167698","San Lorenzo 4645");
		Habitacion auxHabitacion = new Habitacion(4,1500,1);
		Habitacion auxHabitacion2 = new Habitacion(2,1000,2);
		
		
		BaseDeDatos.agregarHabitacion(1, auxHabitacion);
		BaseDeDatos.agregarHabitacion(2, auxHabitacion2);
		
		
		
		aux.HacerReserva();

>>>>>>> 7620333990c345905a086cf9091143bb1ae766dc
	}

}
