package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag tiene atributos pero no cuerpo
public class Etiqueta6 extends TagSupport {

	private String elementos;
	private String nombre;
	private String seleccion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

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
			out.println("<select name='" + nombre + "'"
					+ "onChange='enviar();' >");
			for (String x : data) {
				if (x.trim().equals(seleccion))
					out.println("<option selected>" + x + "</option>");
				else
					out.println("<option>" + x + "</option>");
			}
			out.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}