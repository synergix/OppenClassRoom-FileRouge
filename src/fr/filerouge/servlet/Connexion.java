package fr.filerouge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import fr.filerouge.client.Utilisateurs;
import fr.filerouge.connexion.FormConnexion;

public class Connexion extends HttpServlet {
	private static final String URL = "/WEB-INF/Connexion.jsp";
	private static final String USER = "utilisateur";
	private static final String FORM = "form";
	private static final String SESSION_UTILISATEUR = "utilisateurSession";
	public static final String COOKIE_DERNIERE_CONNEXION = "derneierConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyy HH:mm:ss";
	public static final String INTERVALLE_CONNEXION = "intervalleConnexion";

	public static final String CHAMP_MEMOIRE = "memoire";
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // 1 an
	DateTime dateCourant = new DateTime();
	DateTimeFormatter formt = DateTimeFormat.forPattern(FORMAT_DATE);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dernierConnexion = getCookieValue(req, COOKIE_DERNIERE_CONNEXION);

		if (dernierConnexion != null) {

			DateTime dateDerniereConnxion = formt.parseDateTime(dernierConnexion);
			Period periode = new Period(dateDerniereConnxion, dateCourant);

			PeriodFormatter formatPeriod = new PeriodFormatterBuilder().appendYears().appendSuffix(" an ", " ans ").appendMonths().appendSuffix(" mois ").appendDays().appendSuffix(" jour ", " jours ").appendHours().appendSuffix(" heure ", " heures ")
					.appendMinutes().appendSuffix(" minute ", " minutes ").appendSeparator("et ").appendSeconds().appendSuffix(" seconde", " secondes").toFormatter();
			String intervallePeriod = formatPeriod.print(periode);
			req.setAttribute(INTERVALLE_CONNEXION, intervallePeriod);

		}
		this.getServletContext().getRequestDispatcher(URL).forward(req, resp);
	}

	private String getCookieValue(HttpServletRequest req, String cookieDerniereConnexion) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && cookieDerniereConnexion.equals(cookie.getName())) {
					return cookie.getValue();

				}
			}

		}

		return null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FormConnexion form = new FormConnexion();
		Utilisateurs utilisateur = form.getUtilisateur(req);

		HttpSession session = req.getSession();
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(SESSION_UTILISATEUR, utilisateur);
		} else {
			session.setAttribute(SESSION_UTILISATEUR, null);
		}

		if (req.getParameter(CHAMP_MEMOIRE) != null) {
			String dernierConnexion = dateCourant.toString(formt);
			setCookie(resp, COOKIE_DERNIERE_CONNEXION, dernierConnexion, COOKIE_MAX_AGE);
		} else {
			setCookie(resp, COOKIE_DERNIERE_CONNEXION, "", 0);
		}
		req.setAttribute(FORM, form);
		req.setAttribute(USER, utilisateur);
		 this.getServletContext().getRequestDispatcher(URL).forward(req, resp);
		
	}

	private void setCookie(HttpServletResponse resp, String nom, String valeur, int cookieMaxAge) {
		Cookie cookie = new Cookie(nom, valeur);
		cookie.setMaxAge(cookieMaxAge);
		resp.addCookie(cookie);

	}
}
