package aprendamos.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import java.util.*;

/**
 * Servlet implementation class IdiomaServlet
 */
public class IdiomaServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos el idioma y/o pais seleccionados por el usuario
		String vidioma = request.getParameter("idioma");
		String vpais = request.getParameter("pais");

		// En java, podemos representar un idioma / pais utilizando la clase Locale
		Locale locale = new Locale(vidioma);

		if (vpais != null) {
			locale = new Locale(vidioma, vpais);
		}

		// Utilizando el Locale, indicamos a JSTL cual es el idioma/pais seleccionado por el usuario. 
		// Esta informacion lo almacenaremos en la sesion web
		HttpSession lasesion = request.getSession(false);
		Config.set(lasesion, Config.FMT_LOCALE, locale);

		// Invocamos finalmente a la pagina de bienvenida
		request.getRequestDispatcher("/bienvenida.jsp").forward(request, response);
	}

}