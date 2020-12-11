package aprendamos.java.etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

// La manera mas basica de crear etiquetas es implementando la interface Tag
public class Etiqueta0 implements Tag {

	PageContext pc;

	// Este método se llamará cuando se evalue la etiqueta de fin
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub

		return EVAL_PAGE;
		// return EVAL_PAGE;
		// return SKIP_PAGE;

	}

	// Este método será llamado por Tomcat cuando encuentre la etiqueta en la
	// página jsp
	@Override
	public int doStartTag() throws JspException {
		JspWriter salida = pc.getOut();
		try {
			salida.println("<select name=´'combito' >");
			salida.println("<option value=it >  Italiano  </option>");
			salida.println("<option value=de >  Aleman  </option>");
			salida.println("<option value=es >  Español  </option>");
			salida.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
		// return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPageContext(PageContext pc) {
		// Este metodo se ejecuta primero al invocar a la etiqueta
		// El parametro pc representa la pagina jsp en la cual incrustaremos la
		// etiqueta
		this.pc = pc;

	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub

	}

}