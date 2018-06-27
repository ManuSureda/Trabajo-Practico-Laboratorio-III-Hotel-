package clases;

import java.util.ArrayList;

public class Reserva {
	
	private double costo;
	private int id;
	private boolean reservaUsada;
	private Fechas fechasOcupadas;
	private ArrayList<Habitacion> habitacionesRequeridas;
	private static int contadorId;

	public Reserva(double costoParam, ArrayList<Habitacion> habitacionesParam, Fechas fechasParam) {
		costo = costoParam;
		contadorId++;
		id = contadorId;
		reservaUsada = false;
		habitacionesRequeridas = habitacionesParam;
		fechasOcupadas = fechasParam;
	}
	
	public Reserva() {
		contadorId = 1;
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
	public ArrayList<Habitacion> getHabitacionesRequeridas() {
		return habitacionesRequeridas;
	}
	
	public void setReservaUsada(boolean reservaUsadaParam) {
		reservaUsada = reservaUsadaParam;
	}
	
	public void mostrarReserva() {
		System.out.println("ID Reserva: "+id);
		System.out.println("Fechas ocupadas: "+fechasOcupadas.getFechaInString()+ " al "+fechasOcupadas.getFechaOutString());
		System.out.println("Habitaciones requeridas: ");
			for(Habitacion aux:habitacionesRequeridas) {
				System.out.println(aux);
			}
		if(reservaUsada) {
			 System.out.println("Esta reserva ya ha sido utilizada.");
		}else {
			System.out.println("Reserva sin utilizar.");
		}
	}
	


	
}
