package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecoveryFilmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cod = req.getParameter("filmCod");
		req.setAttribute("filmCod", cod);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}
}