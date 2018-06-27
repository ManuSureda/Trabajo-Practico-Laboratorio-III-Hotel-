package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Habitacion {

	private ArrayList <Fechas> fechaOcupacion;
	private Disponibilidad estado;
	private int capacidad;
	private double precio;
	private int numeroDeHabitacion;
	
	public Habitacion(int capacidadParam,double precioParam,int numeroDeHab)
	{	
		capacidad=capacidadParam;
		precio=precioParam;
		numeroDeHabitacion=numeroDeHab;
	}
	
	
	public void verEstado()
	{
		if(estado.getEstado()==true)
		{
			System.out.println("Disponible");
		}
		else
		{
			System.out.println("No disponible por: "+ estado.getRazon());
		}
	}
	
	//ESTA FUNCION RECORRE EL ARRAYLIST DE FECHAS OCUPADAS Y COMPARAR EL DIA, SI EL DIA DE FIN ES ANTES
	//DEL DIA DE INICIO DE UNA RESERVA EFECTUADA SE FIJA QUE EL DE INICIO ESTE DESPUES DEL DIA DE FIN
	//DE LA RESERVA YA EFECTUADA Y VICEVERSA.
	public boolean verificarDisponibilidadFecha(Date ini,Date fin)
    {  
   	 Iterator it= fechaOcupacion.iterator();
   	 Fechas aux;
   	 Fechas proxima;
   	 boolean flag =true;
   	 
   	 		while(it.hasNext() && flag!=false)
	    	 {
	    		 aux=(Fechas) it.next();
	    		 if(fin.before(aux.getFechaInDate()) || ini.after(aux.getFechaOutDate()))
	    		 {
	    			 if(ini.after(aux.getFechaOutDate()))
	     			{
	     				while(it.hasNext())
	     				{
	     					proxima=(Fechas)it.next();
	     					
	     					if(fin.after(proxima.getFechaInDate()))
	     					{
	     						flag=false;
	     						
	     					}
	     					if(ini.after(proxima.getFechaOutDate()))
	     					{
	     						flag=true;
	     						break;
	     					}					
	     				}
	     			} 
	    		 }    		
	    		 else     			
	    		 {	     			    			 
	    			 flag=false;
	     		 }
   		 
	     	 }
    	 return flag;
   	 }
	
	//Cambia el estado de false a true y viceversa
	public void cambiarEstado()
	{	
		estado.setEstado();
	}
	
	//pone el estado en false y pide un motivo
	public void establecerOcupacionDetallada(String motivoEstado)
	{
		estado.ocupar(motivoEstado);
	}
	
	//pone el estado en true y quita los motivos (si es que hay)
	public void establecerDesocupacion()
	{
		estado.desocupar();
	}


	@Override
	public String toString() {
		return "\nNumero de Habitacion= " + numeroDeHabitacion+"\nCapacidad= " + capacidad + "\nPrecio= " + precio;
	}
	
	
}
