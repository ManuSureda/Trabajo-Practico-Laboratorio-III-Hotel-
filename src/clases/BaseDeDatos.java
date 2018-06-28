package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import interfaces.IArchivar;

public final class BaseDeDatos {
	
	private static HashMap<String,Usuario> baseDatosUsuario = new HashMap<String,Usuario>();
	private static HashMap<Integer,Reserva> baseDatosReserva = new HashMap<Integer,Reserva>();
	private static HashMap<Integer,Habitacion> baseDatosHabitacion = new HashMap<Integer,Habitacion>();
	private BaseDeDatos() {
	}
	
	
	public static Usuario buscarUsuario(String pass, String user) {
		boolean flag = false;
		Iterator it = baseDatosUsuario.entrySet().iterator();
		Usuario usuario = null;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			usuario =(Usuario)entry.getValue();
			if(usuario.getNombreUsuario() == user && usuario.getPassword() == pass) {
				flag = true;
			}
		}	
		return usuario;
	}
	
	public static void agregarHabitacion(int numeroHabitacion,Habitacion hab) 
	{
		baseDatosHabitacion.put(numeroHabitacion, hab);
	}
	
	public static void agregarUsuario(Usuario user)
	{
		baseDatosUsuario.put(user.getNombreUsuario(), user);
	}
	
	public static void agregarReserva(int dni, Reserva res) 
	{
		baseDatosReserva.put(dni, res);
	}
	
	public static void listarHabitaciones()
	{
		Iterator it = baseDatosHabitacion.entrySet().iterator();
		Habitacion habitacion;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			habitacion =(Habitacion)entry.getValue();
			System.out.println(habitacion);
		}
	}
	
	public static void listarUsuarios() 
	{
		Iterator it = baseDatosUsuario.entrySet().iterator();
		Usuario user;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			user =(Usuario)entry.getValue();
			System.out.println(user);
		}
	}
	
	public static void archivarUsuarios() {
        Archivo<String,Usuario> archi = new Archivo<String,Usuario>("usuarios.dat");
        archi.escribirArchivo(baseDatosUsuario);
    }

    public static void leerUsuarios() {
        Archivo<String,Usuario> archi = new Archivo<String,Usuario>("usuarios.dat");
        baseDatosUsuario = archi.leerArchivo();
    }

    public static void archivarReserva() {
        Archivo<Integer,Reserva> archi = new Archivo<Integer,Reserva>("reservas.dat");
        archi.escribirArchivo(baseDatosReserva);
    }

    public static void leerReserva() {
        Archivo<Integer,Reserva> archi = new Archivo<Integer,Reserva>("reservas.dat");
        baseDatosReserva = archi.leerArchivo();
    }

    public static void archivarHabitaciones() {
        Archivo<Integer,Habitacion> archi = new Archivo<Integer,Habitacion>("habitaciones.dat");
        archi.escribirArchivo(baseDatosHabitacion);
    }

    public static void leerHabitaciones() {
        Archivo<Integer,Habitacion> archi = new Archivo<Integer,Habitacion>("habitaciones.dat");
        baseDatosHabitacion = archi.leerArchivo();
    }

	
	
	public static HashMap<Integer, Reserva> getReservas()
	{
		return baseDatosReserva;
	}
	
	public static HashMap<String, Usuario> getBaseUsuarios(){
		return baseDatosUsuario;
	}
	
	public static HashMap<Integer, Habitacion> getBaseHabitaciones(){
		return baseDatosHabitacion;
	}
	
	
	public static void eliminarReserva(int id)
	{
		baseDatosReserva.remove(id);
	}
	
	
	public static void listarHabitacionesDisponibles(Fechas fecha)
	{
		Iterator it = baseDatosHabitacion.entrySet().iterator();
		Habitacion habitacion;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			habitacion =(Habitacion)entry.getValue();
			if(habitacion.verificarDisponibilidadFecha(fecha.getFechaInDate(), fecha.getFechaOutDate()))
			{
				System.out.println(habitacion);
			}
		}
	}
	public static HashMap devolverHabitacionesDisponibles(Fechas fecha)
	{
		HashMap<Integer,Habitacion>habitacionesAPasar = new HashMap();
		Iterator it = baseDatosHabitacion.entrySet().iterator();
		Habitacion habitacion;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			habitacion =(Habitacion)entry.getValue();
			if(habitacion.verificarDisponibilidadFecha(fecha.getFechaInDate(), fecha.getFechaOutDate()))
			{
				habitacionesAPasar.put(habitacion.getNumeroHabitacion(),habitacion);
			}
		}
		BaseDeDatos.listarHabitacionesDisponibles(fecha);
		return habitacionesAPasar;
	}
	
	public static void listarHabitacionesNoDisponibles(Fechas fecha)
	{
		Iterator it = baseDatosHabitacion.entrySet().iterator();
		Habitacion habitacion;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			habitacion =(Habitacion)entry.getValue();
			if(!habitacion.verificarDisponibilidadFecha(fecha.getFechaInDate(), fecha.getFechaOutDate()))
			{
				System.out.println(habitacion);
			}
		}
	}
	
	public static void verTodasLasReservas()
	{
		Iterator it = baseDatosReserva.entrySet().iterator();
		Reserva aux;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			aux =(Reserva)entry.getValue();
			aux.mostrarReserva();
		}	
	}
	
	
}
