package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Consola;

public class UserAssembler {

	public Consola createUserFromRequest(HttpServletRequest request) {

		Consola user = new Consola();
		user.setDni(request.getParameter("dni"));
		user.setNombre(request.getParameter("nombre"));
		user.setApellido(request.getParameter("apellido"));
		return user;
	}

}
