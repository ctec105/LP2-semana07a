package aprendamos.java.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Otra forma de crear etiquetas es utilizando la clase TagSupport
// Este tag tiene atributos pero no cuerpo
public class TagSelectDistritos extends TagSupport {

	private String nombre;
	private List<String> elementos;

	public List<String> getElementos() {
		return elementos;
	}

	public void setElementos(List<String> elementos) {
		this.elementos = elementos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int doEndTag() throws JspException {
		// Dibujaremos otro select
		// referenciamos al JSP utilizando el objeto heredado pageContext
		JspWriter salida = pageContext.getOut();
		try {
			salida.print("<select name=");
			salida.print(this.getNombre());
			salida.println(">");
			salida.println("<option value='01'>Lima</option>");
			salida.println("<option value='02'>Independencia</option>");
			salida.println("<option value='03'>Jesus Maria </option>");
			salida.println("<option value='04'>San Isidro</option>");
			salida.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}