package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag no tiene atributos ni cuerpo
public class Etiqueta4 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		// Obtengo el stream para escribir
		JspWriter out = pageContext.getOut();
		try {
			// Escribo la salida del tag
			out.println("<select>");
			out.println("<option>Mouse</option>");
			out.println("<option>Teclado</option>");
			out.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}