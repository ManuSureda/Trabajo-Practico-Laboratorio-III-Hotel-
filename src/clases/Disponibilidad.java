package clases;

import java.io.Serializable;

public class Disponibilidad implements Serializable{
	
	private boolean estado;
	private String razon;
	
	public Disponibilidad() {
		estado = true;
	    razon = null;
	}

	public void ocupar(String detalleParam) {
		estado = false;
		razon = detalleParam;		
	}
	
	public void desocupar() {
		estado = true;
		razon = null;
	}
	
	public void setRazon(String detalleParam){
		razon = detalleParam;
	}
	
	public String getRazon() {
		return razon;
	}
	
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado() 
	{
		if(estado==false)
		{
			estado=true;
		}
		else
		{
			estado=false;
		}
		
	}

	
	
	
}