package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoJuego {
	private int ID;
	private String edadRecomendada;
	private Date fechaLanzamiento;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	
	public void setFechaLanzamiento(String fecha) {

		try {
			this.fechaLanzamiento = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
