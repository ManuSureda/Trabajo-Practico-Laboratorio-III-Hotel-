package app;

import java.io.IOException;
import java.util.Scanner;

import clases.Administrador;
import clases.BaseDeDatos;
import clases.Cliente;
import clases.Conserje;
import clases.Usuario;

public class Menu {
	
	private Scanner scan;
	
	public void MenuLogin() 
	{
		
		boolean flag=true;
		Usuario aux;

		System.out.println("1. Ingresar al Sistema.");
		System.out.println("2. Registrarse.");
		System.out.println("3. Salir.");
		while(flag)
		{	
			System.out.println("Opcion: ");
		     int respuesta = scan.nextInt();
				switch(respuesta)
				{
					case 1:
					System.out.println("Usuario: ");
					String user = scan.next();
					System.out.println("Password: ");
					String pass = scan.next();
					
					aux  = BaseDeDatos.buscarUsuario(pass, user);
					
					if(aux!=null) 
					{
						
						if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Cliente) {
							Cliente a=(Cliente) aux;
							MenuCliente(a);
						}
						if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Conserje) {
							Conserje a=(Conserje) aux;
							MenuConserje(a);
						}
						if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Administrador) {
							Administrador admin=(Administrador) aux;
							MenuAdm(admin);
						}
					 }
						break;
					case 2:
						registrarCliente();
						break;
					case 3:
						flag=false;
						break;
					
				}
		  }
		
		
		}
		
	
	public void registrarCliente()
	{	String nombreUs,nombre,direccion=null,telefono = null,dni=null,pass = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("Panel de Registro");
		System.out.print("Ingrese su nombre de Usuario: ");
		nombreUs=scan.nextLine();
		System.out.print("Ingrese su nombre de Contraseña: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su nombre: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su DNI: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su nombre de telefono: ");
		nombre=scan.nextLine();
		Cliente aux= new Cliente(nombre,dni,telefono,direccion,nombreUs,pass);
		BaseDeDatos.agregarUsuario(aux);
	}
	public void registrarConserje()
	{	String nombreUs,nombre,direccion=null,telefono = null,dni=null,pass = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("Panel de Registro");
		System.out.print("Ingrese su nombre de Usuario: ");
		nombreUs=scan.nextLine();
		System.out.print("Ingrese su nombre de Contraseña: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su nombre: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su DNI: ");
		nombre=scan.nextLine();
		System.out.print("Ingrese su nombre de telefono: ");
		nombre=scan.nextLine();
		Conserje aux= new Conserje(nombre,dni,telefono,direccion,nombreUs,pass);
		BaseDeDatos.agregarUsuario(aux);
	}
	
	public void MenuCliente(Cliente a) {
		System.out.println("1. Visualizar reserva efectuada.");
		System.out.println("2. Reservar.");
		System.out.println("3. Cancelar reserva.");
		System.out.println("4. Desloguear.");
		boolean flag=true;
		System.out.println("Opcion: ");
		int respuesta = scan.nextInt();
		while(flag)
		switch(respuesta) 
		{
			case 1:
				a.consultarReservas();
			case 2:
				a.HacerReserva();
			case 3:
				System.out.print("\nIngrese el numero de su reserva: ");
				int res=scan.nextInt();
				a.cancelarReserva(res);
			case 4:
				flag=false;
		}
		
	}
	public void MenuConserje(Conserje a) {
		System.out.println("1. Reservar.");
		System.out.println("2. Cancelar reserva.");
		System.out.println("3. Ver todas las reservas.");
		System.out.println("4. Hacer CheckIn");
		System.out.println("5. Hacer CheckOut");
		System.out.println("6. Desloguear.");
		boolean flag=true;
		int idReserva;
		
		while(flag)
		{
			System.out.println("Opcion: ");
			int respuesta = scan.nextInt();
			switch(respuesta) 
			{
				case 1:
					a.HacerReserva();
				case 2:
					System.out.print("\nIngrese el numero de su reserva: ");
					int res=scan.nextInt();
					a.cancelarReserva(res);
				case 3:
					BaseDeDatos.verTodasLasReservas();
				case 4:
					System.out.print("Ingrese el numero de la reserva a hacer CheckIn: ");
					idReserva=scan.nextInt();
					a.hacerCheckIn(idReserva);
				case 5:

					System.out.print("Ingrese el numero de la reserva a hacer CheckOut: ");
					idReserva=scan.nextInt();
					a.hacerCheckOut(idReserva);
				case 6:
					flag=false;
			}
		}
		
		
	}
	public void MenuAdm(Administrador a) {
		System.out.println("1. BackUp.");
		System.out.println("2. Crear Conserje.");
		System.out.println("3. Eliminar Usuario.");
		System.out.println("4. Desloguear.");
		boolean flag=true;
		System.out.println("Opcion: ");
		int respuesta = scan.nextInt();
		while(flag)
		switch(respuesta) 
		{
			case 1:
			try {
				a.escribirArchivoReservas();
				a.escribirArchivoUsuario();
				a.escribirArchivoHabitaciones();
				System.out.println("BackUp realizado con exito.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			case 2:
				registrarConserje();
			case 3:
				System.out.println("Ingrese el nombre de usuario a eliminar: ");
				String name=scan.nextLine();
				a.eliminarUser(name);
			case 4:
				flag=false;
		}
		
	}

}
