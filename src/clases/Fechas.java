package clases;

import java.io.Serializable;
import java.util.Date;

public class Fechas implements Serializable{
	
	private Date fechaIn;
	private Date fechaOut;
	
	public Fechas(Date fechaInParam, Date fechaOutParam) {
		fechaIn = fechaInParam;
		fechaOut = fechaOutParam;
	}
	public Fechas()
	{
		
	}
	
	
	
	public String getFechaIn() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("");
		stringBuilder.append(fechaIn.getDate());
		stringBuilder.append("/");
		stringBuilder.append(fechaIn.getMonth());
		return stringBuilder.toString();
	}


	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}


	public String getFechaOut() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("");
		stringBuilder.append(fechaOut.getDate());
		stringBuilder.append("/");
		stringBuilder.append(fechaOut.getMonth());
		return stringBuilder.toString();
	}


	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}
	
	public int getDayIN() {
		return fechaIn.getDate();
	}
	
	public int getYearIN() {
		return fechaIn.getYear();
	}
	
	public int getMonthIN() {
		return fechaIn.getMonth();
	}
	
	public int getDayOUT() {
		return fechaOut.getDate();
	}
	
	public int getMonthOUT() {
		return fechaOut.getMonth();
	}
	
	public int getYearOUT() {
		return fechaOut.getYear();
	}
	
	public Date getFechaInDate()
	{
		return fechaIn;
	}
	public Date getFechaOutDate()
	{
		return fechaOut;
	}


}

