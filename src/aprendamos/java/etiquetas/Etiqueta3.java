package aprendamos.java.etiquetas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag tiene atributos pero no cuerpo
public class Etiqueta3 extends TagSupport {

	String texto, color, tama;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTama() {
		return tama;
	}

	public void setTama(String tama) {
		this.tama = tama;
	}

	@Override
	public int doStartTag() throws JspException {
		// Obtengo el stream para escribir
		JspWriter out = pageContext.getOut();
		try {
			// Escribo la salida del tag
			out.print("<font color='" + color + "' size='" + tama + "'>");
			out.print(texto);
			out.print("</font>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Este tag no tiene body
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}