package app;

import java.util.Scanner;

import clases.BaseDeDatos;
import excepciones.Conserje;
import usuario.Administrador;
import usuario.Cliente;

public class Menu {
	
	private Scanner scan;
	
	public void MenuLogin() {
		
		System.out.println("Usuario: ");
		String user = scan.next();
		System.out.println("Password: ");
		String pass = scan.next();
		
		boolean retornoBuscarUsuario = BaseDeDatos.buscarUsuario(pass, user);
		
		if(retornoBuscarUsuario) {
			
			if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Cliente) {
				MenuCliente();
			}
			if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Conserje) {
				//MenuConserje();
			}
			if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Administrador) {
				//MenuAdministrador();
			}
		}
		
	}
	
	public void MenuCliente() {
		System.out.println("1. Visualizar reserva efectuada.");
		System.out.println("2. Reservar.");
		System.out.println("3. Cancelar reserva.");
		System.out.println("Other. Desloguear.");
		
		System.out.println("Opcion: ");
		int respuesta = scan.nextInt();
		
		switch(respuesta) {
		case 1: 
		}
		
	}

}
