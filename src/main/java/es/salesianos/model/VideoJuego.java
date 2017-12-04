package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoJuego {
	private String ID;//lo mismo lo pongo en string para que no de error en el assembler
	private String titulo;
	private String edadRecomendada;
	private Date fechaLanzamiento;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
