package aprendamos.java.etiquetas;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

// Este tag tiene atributo pero no cuerpo
public class Etiqueta9 extends TagSupport {

	private Collection<?> data;

	public void setData(Collection<?> c) {
		data = c;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			Iterator<?> it;
			for (it = data.iterator(); it.hasNext();) {
				out.print("<li>" + it.next().toString() + "</li>");
			}
			return SKIP_BODY;
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e);
		}
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}