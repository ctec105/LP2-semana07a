package aprendamos.java.etiquetas;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Este tag tiene atributos pero no cuerpo
public class Etiqueta7 extends TagSupport {

	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int doStartTag() throws JspException {
		// Obtengo el stream para escribir
		JspWriter out = pageContext.getOut();
		try {
			// Escribo la salida del tag
			out.print(fecha);
			// Este tag no tiene body
			return SKIP_BODY;
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e);
		}
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
