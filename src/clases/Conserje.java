package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Conserje extends Usuario{

	public Conserje(String nombreCompleto, String dni, String telefono, String domicilio, String nombreUsuarioParam,
			String passwordParam) {
		super(nombreCompleto, dni, telefono, domicilio, nombreUsuarioParam, passwordParam);
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

	
	public void hacerCheckIn(int idReserva)
	{
		Reserva aux=BaseDeDatos.getReservas().get(idReserva);
		
		if(calcularFechasIguales(aux.getFechasOcupadas().getFechaInDate())==true)
		{
			for(int a:aux.getHabitacionesRequeridas())
			{
				
			}
		}
	}
}
