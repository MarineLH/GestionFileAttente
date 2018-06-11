package priseRDV.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRDV.modele.GestionListeAttente;
import priseRDV.modele.PriseRDVInvalideException;
import priseRDV.modele.PriseRDVService;
import priseRDV.modele.Rdv;

@WebServlet("/priseRDV")
public class PriseRDVControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GestionListeAttente listeAttente = new GestionListeAttente();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/priseRDV.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String civilite = req.getParameter("civilite");
		String sup = req.getParameter("sup");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		boolean urgent = Boolean.valueOf(req.getParameter("urgent"));
		if (sup.equals("rien")) {
			try {
				PriseRDVService rdvService = new PriseRDVService();
				Rdv unRdv = rdvService.rdv(civilite, nom, prenom, urgent);
				boolean place = listeAttente.verificationPlace(unRdv);
				req.setAttribute("Place", place);
				req.setAttribute("sup", sup);
				req.setAttribute("rdv", listeAttente.getListeAttente());
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/validationRDV.jsp");
				rd.forward(req, resp);
			} catch (PriseRDVInvalideException e) {
				req.setAttribute("errors", e.getMessages());
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/priseRDV.jsp");
				rd.forward(req, resp);
			}
		} else {
			listeAttente.supprimer();
			req.setAttribute("rdv", listeAttente.getListeAttente());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/validationRDV.jsp");
			rd.forward(req, resp);
		}
	}
}