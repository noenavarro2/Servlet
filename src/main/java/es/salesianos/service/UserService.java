package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsolaAssembler;
import es.salesianos.connection.ConsolaRepository;
import es.salesianos.model.Consola;

public class UserService implements Service {

	ConsolaAssembler assembler = new ConsolaAssembler();
	private ConsolaRepository repository = new ConsolaRepository();

	public void createNewUserFromRequest(HttpServletRequest req) {
		Consola user = assembler.createUserFromRequest(req);

		if (!repository.search(user).isPresent()) {
			repository.insert(user);
		} else {
			repository.update(user);
		}
	}


}
