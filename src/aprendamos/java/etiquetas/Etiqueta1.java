package aprendamos.java.etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag no tiene atributos ni cuerpo
public class Etiqueta1 extends TagSupport {

	// Este m�todo ser� llamado por Tomcat cuando encuentre la etiqueta en la
	// p�gina jsp
	@Override
	public int doStartTag() throws JspException {
		try {
			// Simplmente obtiene el Stream de salida getOut() para escribir
			// Escribo la salida del tag
			pageContext.getOut().println(
					"Bienvenido a Aprender Como Jugando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Devolvemos SKIP_BODY para indicar que hace falta evaluar el cuerpo
		return SKIP_BODY;
	}

	// Este m�todo se llamar� cuando se evalue la etiqueta de fin
	@Override
	public int doEndTag() throws JspException {
		// Devolvemos EVAL_PAGE para indicar que se puede
		// seguir con el resto de la p�gina
		return EVAL_PAGE;
	}

}