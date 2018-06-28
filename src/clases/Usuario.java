package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import excepciones.FechaInvalidaException;
import excepciones.IdNotFoundException;

public class Usuario extends Persona implements Serializable{

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
			System.out.println("Reserva Eliminada!");
		}
		else
		{
			throw new IdNotFoundException("id incorrecta");
		}
	}
	
	public void listarHabitaciones() 
	{
		BaseDeDatos.listarHabitaciones();
	}

	public void verHabitacionesDisponibles(Fechas fechaElegida)
	{
		BaseDeDatos.listarHabitacionesDisponibles(fechaElegida);
	}

	public void verHabitacionesNoDisponibles(Fechas fechaElegida)
	{
		BaseDeDatos.listarHabitacionesNoDisponibles(fechaElegida);
	}
	
	public double calcularCostoTotal(ArrayList<Integer> hab,Date ini,Date fin)
	{   
		double rta=0;
		double x;
		if (hab!=null)
		{

			for (int i:hab)//revisar si no tiene que tener un -1
			{
				rta+=BaseDeDatos.getBaseHabitaciones().get(i).getPrecio();

			}
			long startTime = ini.getTime();
			long endTime = fin.getTime();
			long diffTime = endTime - startTime;

			x=TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);

			return x*rta;
		}
		else
		{
			return 0;
		}
	}
	public void ingresoFechasEstadia(Fechas f)
	{
		Scanner scan=new Scanner(System.in);
		int day,month,year=0;

		System.out.print("Dia de ingreso: ");
		day = scan.nextInt();
		System.out.print("Mes de ingreso: ");
		month = scan.nextInt();
		if(month < 1 || month > 12) {
			throw new FechaInvalidaException("Mes ingresado incorrecto");
		}
		System.out.print("Año de ingreso: ");
		year = scan.nextInt();
		Date a = new Date(year,month,day);

		System.out.print("Dia de salida: ");
		day = scan.nextInt();
		System.out.print("Mes de salida: ");
		month = scan.nextInt();
		if(month < 1 || month > 12) {
			throw new FechaInvalidaException("Mes ingresado incorrecto");
		}		
		System.out.print("Año de salida: ");
		year = scan.nextInt();
		Date  b = new Date(year,month,day);

		f.setFechaIn(a);
		f.setFechaOut(b);
	
	}
	
	
	/**
	 * Esta funcion se encarga de realizar la reserva de una habitacion.
	 */
	public void HacerReserva()
	{
		
		Reserva r;
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese la cantidad de pasajeros: ");
		int cantPas=sc.nextInt();
		Fechas f = new Fechas();  
		ingresoFechasEstadia(f); //Ingreso de fechas por dia mes y anio, ingreso y salida.
		System.out.println("Habitaciones disponibles: ");  
		HashMap<Integer,Habitacion> listaDeHabitaciones=new HashMap<>(); //HashMap donde se almacenan todas las habitaciones disponibles
		listaDeHabitaciones=BaseDeDatos.devolverHabitacionesDisponibles(f);  //Lista las habitaciones disponibles en las fechas ingresadas.
		
		double costo=0;
		char confirmacion='n';
		ArrayList<Integer> listaDeHabitaciones2=new ArrayList<>(); //ArrayList donde se almacenan las habitaciones deseadas.
		if (listaDeHabitaciones!=null)
		{

			char control;
			
			int cantAux=0;
			Integer hab;
 			System.out.println("Elija las habitaciones que desea ocupar (una por una): ");
			hab=sc.nextInt();//scanea el numero de habitacion.
			cantAux+=BaseDeDatos.getBaseHabitaciones().get(hab).getCapacidad();//suma la capacidad de la habitacion elegida.
			listaDeHabitaciones2.add(hab);//agrega la habitacion elegida al array creado antes.
			System.out.println("Desea contratar otra habitacion? (s/n): ");
			control=sc.next().charAt(0);
			boolean flag =false;
			while (control=='s' && flag!=true)
			{
				if (control=='n' && cantAux<cantPas)
				{
					System.out.println("La capacidad de las habitaciones seleccionadas no es suficiente para la cantidad de pasajeros.");
					System.out.println("Por favor, seleccione otra habitacion o anule la reserva");
					System.out.println("\nDesea contratar otra habitacion? (s/n): ");
					control=sc.next().charAt(0);
					if (control=='n')
					{
						return;
					}
				}
				if (control=='s')
				{
					hab=sc.nextInt();
					listaDeHabitaciones2.add(hab);
					System.out.println("Desea contratar otra habitacion? (s/n): ");
					control=sc.next().charAt(0);
				}

				if (cantAux>=cantPas)
				{
					flag=true;
				}


			}

		}
		if (listaDeHabitaciones2!=null)
		{
			costo=calcularCostoTotal(listaDeHabitaciones2,f.getFechaInDate(),f.getFechaOutDate());
			if(costo==0)
			{
				System.out.println("ERROR EN LA OPERACION");
				return;
			}

			else
				System.out.println("El costo total es de: $"+costo);


		}
		System.out.println("Desea confirmar la operacion? (s/n): ");
		confirmacion=sc.next().charAt(0);

		if (confirmacion=='s')
		{
			r= new Reserva(costo,listaDeHabitaciones2,f);
			for (Integer i:listaDeHabitaciones2)
			{
				BaseDeDatos.getBaseHabitaciones().get(i).setFechaOcupacion(f);
			}
                        
			BaseDeDatos.agregarReserva(r.devolverUltimoId(),r);
			
		}

	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
	}
	
	
	
	

}
