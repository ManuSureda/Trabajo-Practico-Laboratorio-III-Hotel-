package clases;

import java.io.Serializable;

public class Disponibilidad implements Serializable{
	
	private boolean disponible;
	private String detalle;
	
	public Disponibilidad() {
		disponible = true;
		detalle = null;
	}

	public void ocupar(String detalleParam) {
		disponible = false;
		detalle = detalleParam;		
	}
	
	public void desocupar() {
		disponible = true;
		detalle = null;
	}
	
	public void setDetalle(String detalleParam){
		detalle = detalleParam;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public String getDisponibleString() {
		if(disponible) {
			return "Disponible";
		}
		else {
			return "Ocupada";
		}
	}
	
	public boolean getDisponible() {
		return disponible;
	}
}