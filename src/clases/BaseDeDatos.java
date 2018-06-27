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

public final class BaseDeDatos {
	
	private static HashMap<String,Usuario> baseDatosUsuario = new HashMap<String,Usuario>();
	private static HashMap<Integer,Cliente> baseDatosCliente = new HashMap<Integer,Cliente>();
	private static HashMap<Integer,Reserva> baseDatosReserva = new HashMap<Integer,Reserva>();
	private static HashMap<Integer,Habitacion> baseDatosHabitacion = new HashMap<Integer,Habitacion>();
	
	private BaseDeDatos() {
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
	
	public static void agregarHabitacion(int numeroHabitacion,Habitacion hab) 
	{
		baseDatosHabitacion.put(numeroHabitacion, hab);
	}
	
	public static void agregarUsuario(String pass, Usuario user)
	{
		baseDatosUsuario.put(pass, user);
	}
	
	public static void agregarCliente(int dni, Cliente psj) 
	{
		baseDatosCliente.put(dni, psj);
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
	
	public static void listarPasajeros() 
	{
		Iterator it = baseDatosCliente.entrySet().iterator();
		Cliente psj;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			psj =(Cliente)entry.getValue();
			System.out.println(psj);
		}
	}
	
	public static void escribirArchivoUsuario()
	{
		try {
			
			FileOutputStream fos = new FileOutputStream("usuarios.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosUsuario);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void leerArchivoUsuario()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		
		try {
			FileInputStream fis = new FileInputStream("usuarios.dat");
			ObjectInputStream obj = new ObjectInputStream(fis);
			baseDatosUsuario=(HashMap<String, Usuario>) obj.readObject();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void escribirArchivoHabitaciones()
	{
		try {
			
			FileOutputStream fos = new FileOutputStream("habitaciones.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosHabitacion);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void leerArchivoHabitaciones()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		
		try {
			FileInputStream fis = new FileInputStream("habitaciones.dat");
			ObjectInputStream obj = new ObjectInputStream(fis);
			baseDatosHabitacion = (HashMap<Integer, Habitacion>) obj.readObject();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void escribirArchivoReservas()
	{
		try {
			
			FileOutputStream fos = new FileOutputStream("reservas.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosReserva);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void leerArchivoReservas()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		
		try {
			FileInputStream fis = new FileInputStream("reservas.dat");
			ObjectInputStream obj = new ObjectInputStream(fis);
			baseDatosReserva=(HashMap<Integer, Reserva>) obj.readObject();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void escribirArchivoCliente()
	{
		try {
			
			FileOutputStream fos = new FileOutputStream("clientes.dat");
			ObjectOutputStream obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosCliente);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void leerArchivoCliente()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		
		try {
			FileInputStream fis = new FileInputStream("clientes.dat");
			ObjectInputStream obj = new ObjectInputStream(fis);
			baseDatosCliente = (HashMap<Integer, Cliente>) obj.readObject();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public static HashMap<Integer, Cliente> getBaseClientes(){
		return baseDatosCliente;
	}
	
	public static void eliminarReserva(int id)
	{
		baseDatosReserva.remove(id);
	}
}
