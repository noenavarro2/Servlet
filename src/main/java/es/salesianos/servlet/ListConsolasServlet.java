package es.salesianos.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConsolaRepository;
import es.salesianos.model.Consola;

public class ListConsolasServlet extends HttpServlet {

	ConsolaRepository consolaReposirory = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Consola> listAllConsolas = consolaReposirory.listAllConsolas();
		req.getSession().setAttribute("consolas", listAllConsolas);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoConsola.jsp");
		dispatcher.forward(req, resp);
	}
}
