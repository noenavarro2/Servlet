package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsolaAssembler;
import es.salesianos.connection.ConsolaRepository;
import es.salesianos.model.Consola;

public class ConsolaService implements Service {

	ConsolaAssembler assembler = new ConsolaAssembler();
	private ConsolaRepository repository = new ConsolaRepository();

	public void createNewUserFromRequest(HttpServletRequest req) {
		Consola consola = assembler.createConsolaFromRequest(req);

		if (!repository.search(consola).isPresent()) {
			repository.insert(consola);
		} else {
			repository.update(consola);
		}
	}


}
