package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Consola;

public class ConsolaAssembler {

	public Consola createConsolaFromRequest(HttpServletRequest request) {
		//al haber otro metodo parecido que es VideoJuegoAssembler lo suto seria hacer una interface u una clase padre
		//asi nos ahorramos codigo pero como es el examen y el tiempo es justo lo hago separado
		Consola consola = new Consola();
		consola.setID(request.getParameter("ID"));
		consola.setNombre(request.getParameter("nombre"));
		consola.setEmpresa(request.getParameter("empresa"));
		return consola;
	}

}
