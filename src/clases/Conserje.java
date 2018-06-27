package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Conserje extends Usuario{

	public Conserje(String nombreCompleto, String dni, String telefono, String domicilio, String nombreUsuarioParam,
			String passwordParam) {
		super(nombreCompleto, dni, telefono, domicilio, passwordParam, passwordParam);
		// TODO Auto-generated constructor stub
	}
	
	public boolean calcularFechasIguales(Date fechaReservaInicio)
	{
			double x;
			
		        Calendar fecha = Calendar.getInstance();
		        Date fechaAuxiliar=fecha.getTime();
				long startTime = fechaReservaInicio.getTime();
				long endTime =   fechaAuxiliar.getTime();
				long diffTime = endTime - startTime;
				x=TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
				if(x==0)
				{
					return true;
				}
				else
				{
					return false;
				}
	}

	public boolean calcularFechasIgualesParaCheckOut(Date fechaReservaInicio)
	{
			double x;
			
		        Calendar fecha = Calendar.getInstance();
		        Date fechaAuxiliar=fecha.getTime();
				long startTime = fechaReservaInicio.getTime();
				long endTime =   fechaAuxiliar.getTime();
				long diffTime = endTime - startTime;
				x=TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
				if(fechaAuxiliar.compareTo(fechaReservaInicio) >= 0)
				{
					return true;
				}
				else
				{
					return false;
				}
	}
	
	public void hacerCheckIn(int idReserva)
	{
		Reserva aux=BaseDeDatos.getReservas().get(idReserva);
		ArrayList<Integer> numeroHabitacionesAuxiliares = aux.getHabitacionesRequeridas();
		if(calcularFechasIguales(aux.getFechasOcupadas().getFechaInDate())==true)
		{
			for (int i = 0; i < numeroHabitacionesAuxiliares.size(); i++) {
				int a = numeroHabitacionesAuxiliares.get(i);
				BaseDeDatos.getBaseHabitaciones().get(a).cambiarEstado();
			}
		}
		else
		{
			System.out.println("Aun no esta en fecha para hacer el CheckIn");
		}
	}
	public void hacerCheckOut(int idReserva)
	{
		Reserva aux=BaseDeDatos.getReservas().get(idReserva);
		ArrayList<Integer> numeroHabitacionesAuxiliares = aux.getHabitacionesRequeridas();
		if(calcularFechasIgualesParaCheckOut(aux.getFechasOcupadas().getFechaInDate())==true)
		{
			for (int i = 0; i < numeroHabitacionesAuxiliares.size(); i++) {
				int a = numeroHabitacionesAuxiliares.get(i);
				BaseDeDatos.getBaseHabitaciones().get(a).cambiarEstado();
			}
		}
		else
		{
			System.out.println("Aun no esta en fecha para hacer el CheckOut");
		}
	}
}
