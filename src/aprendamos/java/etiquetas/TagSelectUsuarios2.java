package aprendamos.java.etiquetas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import aprendamos.java.util.MySqlDbConn;

// Este tag tiene atributos pero no cuerpo
public class TagSelectUsuarios2 extends TagSupport {

	private int fecnac;

	public int getFecnac() {
		return fecnac;
	}

	public void setFecnac(int fecnac) {
		this.fecnac = fecnac;
	}

	@Override
	public int doStartTag() throws JspException {

		// Obtener la conexión a bd
		Connection con = MySqlDbConn.obtenerConexion();

		Calendar fecActual = Calendar.getInstance();
		int mes = fecActual.get(Calendar.MONTH);

		// Instrucción sql que seleccione a los usuarios que son del mes de mayo
		String sql = "select * from tbusuario where month(fecnac)=?";

		try {
			// Preparamos la sententcia
			PreparedStatement pst = con.prepareStatement(sql);
			// Pasos los parametros
			pst.setInt(1, fecnac);
			// Ejecutamos el query
			ResultSet rs = pst.executeQuery();
			// Obtengo el stream para escribir
			JspWriter salida = pageContext.getOut();
			try {
				// Escribo la salida del tag
				salida.print("<select name=lista2>");
				while (rs.next()) {
					salida.print("<option>" + rs.getString(3) + "</option>");
				}
				salida.print("</select>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Tag sin cuerpo
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}