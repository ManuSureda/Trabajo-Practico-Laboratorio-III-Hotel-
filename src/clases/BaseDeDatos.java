package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class BaseDeDatos {
	private static HashMap<String,Usuario> baseDatosUsuario = new HashMap<String,Usuario>();
	private static HashMap<Integer,Cliente> baseDatosCliente = new HashMap<Integer,Cliente>();
	private static HashMap<Integer,Reserva> baseDatosReserva = new HashMap<Integer,Reserva>();
	private static ArrayList<Habitacion> baseDatosHabitacion = new ArrayList<Habitacion>();
	
	private BaseDeDatos() {
	}
	
	public static void agregarHabitacion(Habitacion hab) {
		baseDatosHabitacion.add(hab);
	}
	
	public static boolean buscarUsuario(String pass, String user) {
		boolean flag = false;
		Iterator it = baseDatosUsuario.entrySet().iterator();
		Usuario usuario;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			usuario =(Usuario)entry.getValue();
			if(usuario.getNombreUsuario() == user && usuario.getPassword() == pass) {
				flag = true;
			}
		}	
		return flag;
	}
	
	public static void agregarUsuario(String pass, Usuario user) {
		baseDatosUsuario.put(pass, user);
	}
	
	public static void agregarCliente(int dni, Cliente psj) {
		baseDatosCliente.put(dni, psj);
	}
	
	public static void agregarReserva(int dni, Reserva res) {
		baseDatosReserva.put(dni, res);
	}
	
	public static void listarHabitaciones() {
		for(Habitacion e: baseDatosHabitacion) {
			System.out.println(e);
		}
	}
	
	public static void listarUsuarios() {
		Iterator it = baseDatosUsuario.entrySet().iterator();
		Usuario user;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			user =(Usuario)entry.getValue();
			System.out.println(user);
		}
	}
	
	public static void listarPasajeros() {
		Iterator it = baseDatosCliente.entrySet().iterator();
		Cliente psj;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			psj =(Cliente)entry.getValue();
			System.out.println(psj);
		}
	}
}
