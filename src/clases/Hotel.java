package clases;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import excepciones.LoginIncorrectoException;

public class Hotel implements Serializable{

	private Scanner scan=new Scanner(System.in);
	private String nombre;
	private String direccion;
	private String telefono;
	public Hotel(String nombre,String direccion,String telefono)
	{
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public void MenuLogin() 
	{
	
		boolean flag=true;
		boolean vof=false;
		int respuesta;
		int contador=0;
		Usuario aux;
		System.out.println("***** Bienvenido al Hotel Costa Esmeralda *****");
		System.out.println("1. Ingresar al Sistema.");
		System.out.println("2. Registrarse.");
		System.out.println("3. Salir.");
		while(flag)
		{	
			System.out.println("\nOpcion de menu: ");
		      respuesta= scan.nextInt();
				switch(respuesta)
				{
					case 1:
						String user;
						String pass; 
					while(vof==false && contador<5)
					{
						

						try {
							System.out.println("Usuario: ");
							user = scan.next();
							System.out.println("Password: ");
							pass = scan.next();
							aux  = BaseDeDatos.buscarUsuario(pass, user);
							if(aux!=null) 
							{
								
								if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Cliente) {
									Cliente a=(Cliente) aux;
									MenuCliente(a);
									aux=null;
								}
								if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Conserje) {
									Conserje a=(Conserje) aux;
									MenuConserje(a);
									aux=null;
								}
								if(BaseDeDatos.getBaseUsuarios().get(user) instanceof Administrador) {
									Administrador admin=(Administrador) aux;
									MenuAdm(admin);
									aux=null;
								}
							 }
							vof=true;
						} catch (LoginIncorrectoException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						contador++;
					}
					
					
					
						break;
					case 2:
						registrarCliente();
						break;
					case 3:
						flag=false;
						System.out.println("Adios!");
						break;
					default:
						flag=false;
						
					
				}
		  }
		
		
		}
		
	/**
	 * Esta funcion solo se utiliza para registrar clientes, pedira los datos de Persona.
	 */
	public void registrarCliente()
	{	String nombreUs,nombre,direccion=null,telefono = null,dni=null,pass = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("Panel de Registro");
		System.out.print("Ingrese su nombre de Usuario: ");
		nombreUs=scan.next();
		System.out.print("Ingrese su nombre de Contraseņa: ");
		pass=scan.next();
		System.out.print("Ingrese su nombre: ");
		nombre=scan.next();
		System.out.print("Ingrese su DNI: ");
		dni=scan.next();
		System.out.print("Ingrese su nombre de telefono: ");
		telefono=scan.next();
		Cliente aux= new Cliente(nombre,dni,telefono,direccion,nombreUs,pass);
		BaseDeDatos.agregarUsuario(aux);
		
	}
	/**
	 * Esta funcion solo se utiliza para registrar conserjes, pedira los datos de Persona. UNICAMENTE UTILIZADA POR UN ADM
	 */
	public void registrarConserje()
	{	String nombreUs,nombre,direccion=null,telefono = null,dni=null,pass = null;
		Scanner scan=new Scanner(System.in);
		System.out.println("Panel de Registro");
		System.out.print("Ingrese su nombre de Usuario: ");
		nombreUs=scan.next();
		System.out.print("Ingrese su nombre de Contraseņa: ");
		pass=scan.next();
		System.out.print("Ingrese su nombre: ");
		nombre=scan.next();
		System.out.print("Ingrese su DNI: ");
		dni=scan.next();
		System.out.print("Ingrese su nombre de telefono: ");
		telefono=scan.next();
		Conserje aux= new Conserje(nombre,dni,telefono,direccion,nombreUs,pass);
		BaseDeDatos.agregarUsuario(aux);
	}
	/**
	 * Menu para navegar entre las opciones de un Cliente
	 * @param Cliente
	 */
	public void MenuCliente(Cliente a) {
		System.out.println("1. Visualizar reserva efectuada.");
		System.out.println("2. Reservar.");
		System.out.println("3. Cancelar reserva.");
		System.out.println("4. Desloguear.");
		boolean flag=true;
		int res;
		int respuesta;
		while(flag)
		{	System.out.println("Opcion de menu: ");
			respuesta = scan.nextInt();
			switch(respuesta) 
			{
				case 1:
					System.out.print("\nIngrese el numero de su reserva: ");
				    res=scan.nextInt();
					//a.consultarReservas(res);
				   // BaseDeDatos.verTodasLasReservas();
					break;
				case 2:
					a.HacerReserva();
					break;
				case 3:
					System.out.print("\nIngrese el numero de su reserva: ");
					res=scan.nextInt();
					a.cancelarReserva(res);
					break;
				case 4:
					flag=false;
					break;
				default:
					flag=false;
			}
		}
		
		
	}
	/**
	 * Menu para navegar entre las opciones de un Conserje
	 * @param Conserje
	 */
	public void MenuConserje(Conserje a) {
		System.out.println("1. Reservar.");
		System.out.println("2. Cancelar reserva.");
		System.out.println("3. Ver todas las reservas.");
		System.out.println("4. Hacer CheckIn");
		System.out.println("5. Hacer CheckOut");
		System.out.println("6. Habitacion no disponible (con motivo).");
		System.out.println("7. Cambiar estado de habitacion.");
		System.out.println("8. Desloguear.");
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
					System.out.print("Ingrese el numero de la habitacion para quitar de disponible: ");
					idReserva=scan.nextInt();System.out.print("Ingrese el numero de la habitacion para quitar de disponible: ");
					String motivo =scan.next();
					BaseDeDatos.getBaseHabitaciones().get(idReserva).establecerOcupacionDetallada(motivo);
				case 7:
					System.out.print("Ingrese el numero de la habitacion cambiar estado: ");
					idReserva=scan.nextInt();
					BaseDeDatos.getBaseHabitaciones().get(idReserva).cambiarEstado();
				default:
					flag=false;
			}
		}
		
		
	}
	/**
	 * Menu para los Administradores
	 * @param Administrador
	 */
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
			default:
				flag=false;
		}
		
	}

}
