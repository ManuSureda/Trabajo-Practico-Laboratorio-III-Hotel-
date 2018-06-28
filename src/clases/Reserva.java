package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Reserva implements Serializable{
	
	private double costo;
	private int id;
	private boolean reservaUsada;
	private Fechas fechasOcupadas;
	private ArrayList<Integer> habitacionesRequeridas;

	public Reserva(double costoParam, ArrayList<Integer> habitacionesParam, Fechas fechasParam) {
		costo = costoParam;
		
		id = devolverUltimoId();
		reservaUsada = false;
		habitacionesRequeridas = habitacionesParam;
		fechasOcupadas = fechasParam;
	}
	
	public double getCosto() {
		return costo;
	}
	public int getId() {
		return id;
	}
	public Fechas getFechasOcupadas() {
		return fechasOcupadas;
	}
	public ArrayList<Integer> getHabitacionesRequeridas() {
		return habitacionesRequeridas;
	}
	
	public void setReservaUsada(boolean reservaUsadaParam) {
		reservaUsada = reservaUsadaParam;
	}
	
	public void mostrarReserva() {
		System.out.println("ID Reserva: "+id);
		System.out.println("Fechas ocupadas: "+fechasOcupadas.getFechaInString()+ " al "+fechasOcupadas.getFechaOutString());
		System.out.println("Habitaciones requeridas: ");
			for(int aux:habitacionesRequeridas) {
				System.out.println(aux);
			}
		if(reservaUsada) {
			 System.out.println("Esta reserva ya ha sido utilizada.");
		}else {
			System.out.println("Reserva sin utilizar.");
		}
	}
	
	
	public int devolverUltimoId()
	{
		Iterator it = BaseDeDatos.getReservas().entrySet().iterator();
		Reserva reserva;
		int id=0;
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			reserva =(Reserva)entry.getValue();
			if(reserva.getId()>id)
			{
				id=reserva.getId();
			}
		}
		return id+1;
	}

	
}
