package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

// Este tag no tiene atributos pero si cuerpo
public class Etiqueta8 extends BodyTagSupport {

	// Este metodo procesa el body
	public int doAfterBody() throws JspException {
		try {
			BodyContent bc = getBodyContent();
			String cuerpo = bc.getString();
			JspWriter out = bc.getEnclosingWriter();
			if (cuerpo != null) {
				for (int i = cuerpo.length() - 1; i >= 0; i--) {
					out.print(cuerpo.charAt(i));
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new JspException(ex);
		}
		return SKIP_BODY;
	}

}