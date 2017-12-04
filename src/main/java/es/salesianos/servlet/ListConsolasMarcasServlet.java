package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

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


	VideoJuegoRepository videoJuegoReposirory = new VideoJuegoRepository();
	ConsolaRepository consolaReposirory = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoJuego> listAllVideoJuegos = videoJuegoReposirory.listAllVideoJuegos();
		List<Consola> listAllConsolas = consolaReposirory.listAllVideoJuegos();
		req.getSession().setAttribute("videojuegos",  listAllVideoJuegos);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoConsolasMarcas.jsp");
		dispatcher.forward(req, resp);
	}
}
