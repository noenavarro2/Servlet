package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Consola;
import es.salesianos.model.VideoJuego;

public class VideoJuegoAssembler {

	public VideoJuego createVideoJuegoFromRequest(HttpServletRequest request) {
		//al haber otro metodo parecido que es VideoJuegoAssembler lo suto seria hacer una interface u una clase padre
		//asi nos ahorramos codigo pero como es el examen y el tiempo es justo lo hago separado
		VideoJuego videojuego= new VideoJuego();
		videojuego.setID(request.getParameter("ID"));
		videojuego.setTitulo(request.getParameter("titulo"));
		videojuego.setEdadRecomendada(request.getParameter("edadRecomendada"));
		videojuego.setFechaLanzamiento(request.getParameter("fecha"));
		return videojuego;
	}

}
