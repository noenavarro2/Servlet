package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.VideoJuegoRepository;
import es.salesianos.model.VideoJuego;


public class ListVideoJuegosServlet extends HttpServlet {

	VideoJuegoRepository videoJuegoReposirory = new VideoJuegoRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoJuego> listAllVideoJuegos = videoJuegoReposirory.listAllVideoJuegos();
		req.getSession().setAttribute("videojuegos",  listAllVideoJuegos);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoVideoJuego.jsp");
		dispatcher.forward(req, resp);
	}
}
