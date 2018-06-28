package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import interfaces.IArchivar;

public class Administrador extends Usuario implements IArchivar {

	public Administrador(String nombreCompleto, String dni, String telefono, String domicilio,
			String nombreUsuarioParam, String passwordParam) {
		super(nombreCompleto, dni, telefono, domicilio, nombreUsuarioParam, passwordParam);
	}

	@Override
	/**
	 * Funcion que crea un BackUp de las Habitaciones en un ARCHIVO
	 */
	public void escribirArchivoHabitaciones() throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;
		
		try {
			fos = new FileOutputStream("habitacionesBackUp.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(BaseDeDatos.getBaseHabitaciones());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
				fos.close();
				obj.close();
		}
	}
	@Override
	/**
	 * Funcion que crea un BackUp de las Reservas en un ARCHIVO
	 */
	public void escribirArchivoReservas() throws IOException {
		
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;
		
		try {
			fos = new FileOutputStream("reservasBackUp.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(BaseDeDatos.getReservas());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			fos.close();
			obj.close();
		}
	}

	@Override
	/**
	 * Funcion que crea un BackUp de los Usuarios en un ARCHIVO
	 */
	public void escribirArchivoUsuario() throws IOException {
		
		FileOutputStream fos = null;
		ObjectOutputStream obj = null;
		
		try {
			fos = new FileOutputStream("usuariosBackUp.dat");
			obj = new ObjectOutputStream(fos);
			obj.writeObject(BaseDeDatos.getBaseUsuarios());
			
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
	 * Recorre la base de datos de Usuarios(mapa) y elimina cuando encuentra el nombre
	 * @param Nombre de usuario
	 */
	public void eliminarUser(String nUser)
    {
        BaseDeDatos.getBaseUsuarios().remove(nUser);
        System.out.println("Usuario eliminado.");
    }
	

	

}
