package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;


import es.salesianos.assembler.ConsolaAssembler;
import es.salesianos.assembler.VideoJuegoAssembler;
import es.salesianos.connection.ConsolaRepository;
import es.salesianos.connection.VideoJuegoRepository;
import es.salesianos.model.VideoJuego;


public class VideoJuegoService implements Service {

	VideoJuegoAssembler assembler = new VideoJuegoAssembler();
	private VideoJuegoRepository repository = new VideoJuegoRepository();

	public void createNewUserFromRequest(HttpServletRequest req) {
		VideoJuego videojuego = assembler.createVideoJuegoFromRequest(req);

		if (!repository.search(videojuego, null).isPresent()) {
			repository.insert(videojuego);
		} else {
			repository.update(videojuego);
		}
	}


}
