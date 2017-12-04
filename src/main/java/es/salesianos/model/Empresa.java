package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {

	private int ID;
	private String nombre;
	private Date fecha;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {

		try {
			this.fecha = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
