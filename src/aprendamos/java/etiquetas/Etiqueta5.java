package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag tiene atributos pero no cuerpo
public class Etiqueta5 extends TagSupport {

	private String elementos;

	public String getElementos() {
		return elementos;
	}

	public void setElementos(String elementos) {
		this.elementos = elementos;
	}

	@Override
	public int doStartTag() throws JspException {
		// Obtengo el stream para escribir
		JspWriter out = pageContext.getOut();
		String[] data = elementos.split(",");
		try {
			// Escribo la salida del tag
			out.println("<select>");
			for (String x : data) {
				out.println("<option>" + x + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}