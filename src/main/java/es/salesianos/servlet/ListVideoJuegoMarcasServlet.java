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

public class ListVideoJuegoMarcasServlet extends HttpServlet {


	VideoJuegoRepository videoJuegoReposirory = new VideoJuegoRepository();


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoJuego videojuego = null;
		Consola consola = null;
		Optional<VideoJuego> listAllVideoJuegosporMarca = videoJuegoReposirory.search(videojuego, consola);
		req.getSession().setAttribute("videojuegosmarcas",  listAllVideoJuegosporMarca);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoVideoJuegosMarcas.jsp");
		dispatcher.forward(req, resp);
	}
}
