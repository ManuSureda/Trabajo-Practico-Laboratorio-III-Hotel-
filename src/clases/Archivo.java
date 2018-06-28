package clases;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Archivo<K,V> implements Serializable {
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private HashMap<K,V> retornoHashMap;
	private String rutaDelArchivo;
	
	public Archivo (String rutaDelArchivo) {
		this.rutaDelArchivo = rutaDelArchivo;
		salida = null;
		entrada = null;
		retornoHashMap = null;
	}
	
	/*
	 * Metodo para Escribir en un archivo un hashmap
	 */
	public void escribirArchivo(HashMap<K,V> hashMapParaGuardar) {
		
		try {
			salida = new ObjectOutputStream(new FileOutputStream(rutaDelArchivo));
			salida.writeObject(hashMapParaGuardar);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Metodo para Leer un archivo y retornar un hashMap, para luego almacernarlo en la base de datos
	 */
	public HashMap<K,V> leerArchivo(){
		try {
			entrada = new ObjectInputStream(new FileInputStream(rutaDelArchivo));
			retornoHashMap = (HashMap<K, V>) entrada.readObject();
		}catch(EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return retornoHashMap;
	}
	

}
