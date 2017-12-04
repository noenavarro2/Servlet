package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConsolaRepository;
import es.salesianos.connection.VideoJuegoRepository;
import es.salesianos.model.Consola;
import es.salesianos.model.VideoJuego;

public class ListConsolasMarcasServlet extends HttpServlet {


	
	ConsolaRepository consolaReposirory = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Consola consola = null;
		Optional<Consola> searchConsolaMarca= consolaReposirory.search(consola);
		req.getSession().setAttribute("consolaMarca",  searchConsolaMarca);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoConsolasMarcas.jsp");
		dispatcher.forward(req, resp);
	}
}
