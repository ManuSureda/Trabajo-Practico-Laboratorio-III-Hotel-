package app;

import java.util.ArrayList;

public class Reserva {
	
	private double costo;
	private String dni;
	private boolean reservaUsada;
	private Fechas fechasOcupadas;
	private ArrayList<Habitacion> habitacionesRequeridas;

	public Reserva(double costoParam, String dniParam, ArrayList<Habitacion> habitacionesParam, Fechas fechasParam) {
		costo = costoParam;
		dni = dniParam;
		reservaUsada = false;
		habitacionesRequeridas = habitacionesParam;
		fechasOcupadas = fechasParam;
	}
	
	
	public void mostrarReserva() {
		System.out.println("ID Reserva: "+dni);
		System.out.println("Fechas ocupadas: "+fechasOcupadas.getFechaIn()+ " al "+fechasOcupadas.getFechaOut());
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
	
	public void setReservaUsada(boolean reservaUsadaParam) {
		reservaUsada = reservaUsadaParam;
	}

	
}
