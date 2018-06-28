package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import excepciones.LoginIncorrectoException;
import interfaces.IArchivar;

public final class BaseDeDatos implements Serializable{

	private static HashMap<String,Usuario> baseDatosUsuario = new HashMap<String,Usuario>();
	private static HashMap<Integer,Reserva> baseDatosReserva = new HashMap<Integer,Reserva>();
	private static HashMap<Integer,Habitacion> baseDatosHabitacion = new HashMap<Integer,Habitacion>();
	private BaseDeDatos() {
	}

	/**
	 * Recorre la base de datos de usuarios para encontrar el usuario que coincide con el nombre y contraseña pasados por parametro.
	 * @param Contraseña
	 * @param Nombre de Usuario
	 * @return Retorna el Usuario en cuestion
	 * @throws LoginIncorrectoException 
	 */
	public static Usuario buscarUsuario(String pass, String user) throws LoginIncorrectoException {
		boolean flag = false;
		Iterator it = baseDatosUsuario.entrySet().iterator();
		Usuario usuario = null;
		while(it.hasNext()) 
		{
			Map.Entry entry = (Map.Entry)it.next();
			usuario =(Usuario)entry.getValue();
			if(usuario.getNombreUsuario().equals(user) && usuario.getPassword().equals(pass)) {
				flag = true;
				return usuario;
			}
			else
			{
				usuario=null;
			}
		}	
		
		if(usuario==null) {
			
			throw new LoginIncorrectoException("El usuario o la pass son incorrectos.");

		}
		
		return usuario;
		/*if(BaseDeDatos.baseDatosUsuario.containsKey(user))
		{
			if(BaseDeDatos.baseDatosUsuario.get(user).getPassword().equals(pass))
			{
				return BaseDeDatos.baseDatosUsuario.get(user);
			}
			else
			{
				throw new LoginIncorrectoException("Contraseña incorrecta.");
			}
		}
		else {
			throw new LoginIncorrectoException("Usuario incorrecto");
		}*/
		
	}
	/**
	 * Añade una habitacion al mapa de habitaciones
	 * @param Numero de Habitacion
	 * @param objeto de Habitacion
	 */
	public static void agregarHabitacion(int numeroHabitacion,Habitacion hab) 
	{
		baseDatosHabitacion.put(numeroHabitacion, hab);
	}
	/**
	 * Añade un Usuario al mapa de usuarios
	 * @param objeto de usuario
	 */
	public static void agregarUsuario(Usuario user)
	{
		baseDatosUsuario.put(user.getNombreUsuario(), user);
	}
	/**
	 * Añade una reserva al mapa de reservas
	 * @param Id de la reserva
	 * @param objeto Reserva
	 */
	public static void agregarReserva(int dni, Reserva res) 
	{
		baseDatosReserva.put(dni, res);
	}
	/**
	 * Recorre el mapa de habitaciones y lo muestra
	 */
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
	/**
	 * Recorre el mapa de usuarios y los muestra
	 */
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

	/**
	 * Guarda en un archivo el mapa de usuarios
	 * @throws IOException
	 */
	public static void escribirArchivoUsuario() throws IOException
	{
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;

		try {

			fos = new FileOutputStream("usuarios.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosUsuario);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			fos.close();
			obj.close();
		}
	}
	/**
	 * Carga el mapa con el mapa que levanta de un archivo
	 */
	public static void leerArchivoUsuario()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		FileInputStream fis = null;
		ObjectInputStream obj = null;

		try {
			fis = new FileInputStream("usuarios.dat");
			obj = new ObjectInputStream(fis);
			baseDatosUsuario=(HashMap<String, Usuario>) obj.readObject();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			try {
				fis.close();
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	/**
	 * Guarda el mapa de habitaciones en un archivo
	 */
	public static void escribirArchivoHabitaciones()
	{
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;

		try {

			fos = new FileOutputStream("habitaciones.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosHabitacion);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally { 
			try {
				fos.close();
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	/**
	 * 
	 * 
	 */
	public static void leerArchivoHabitaciones()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		FileInputStream fis = null;
		ObjectInputStream obj = null;


		try {
			fis = new FileInputStream("habitaciones.dat");
			obj = new ObjectInputStream(fis);
			baseDatosHabitacion = (HashMap<Integer, Habitacion>) obj.readObject();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void escribirArchivoReservas()
	{
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;
		try {

			fos = new FileOutputStream("reservas.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(baseDatosReserva);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try { 
				fos.close();
				obj.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void leerArchivoReservas()
	{
		ArrayList usuarioAuxiliar=new ArrayList();
		FileInputStream fis = null;
		ObjectInputStream obj = null;
		try {
			fis = new FileInputStream("reservas.dat");
			obj = new ObjectInputStream(fis);
			baseDatosReserva=(HashMap<Integer, Reserva>) obj.readObject();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				obj.close();
			} catch(IOException e) {
				e.printStackTrace();
			}

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
