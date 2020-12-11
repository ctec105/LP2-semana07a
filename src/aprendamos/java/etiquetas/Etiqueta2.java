package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

// Este tag tiene atributos y cuerpo
public class Etiqueta2 extends BodyTagSupport {

	int veces = 0;

	public int getVeces() {
		return veces;
	}

	public void setVeces(int veces) {
		this.veces = veces;
	}

	// Se ejecuta despues de comprobar el contenido del cuerpo de la etiqueta:
	@Override
	public int doAfterBody() throws JspException {
		if (veces-- > 0) {
			try {
				// Obtengo el stream para escribir
				BodyContent bc = getBodyContent();
				JspWriter out = bc.getEnclosingWriter();
				// Escribo la salida del tag
				out.println(bc.getString());
				bc.clearBody();
			} catch (IOException e) {
				System.out.println("Error en tag Bucle: " + e.getMessage());
			}
			// Cuando se necesita que se evalue mas de una vez el cuerpo devolvemos EVAL_BODY_TAG en lugar de SKYP_BODY
			return EVAL_BODY_TAG;
		} else
			// No tiene cuerpo
			return SKIP_BODY;
	}

}