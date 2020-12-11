package aprendamos.java.etiquetas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import aprendamos.java.util.MySqlDbConn;

// Este tag tiene atributos pero no cuerpo
public class TagSelectUsuarios extends TagSupport {

	private String dist;
	private String letra;

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public int doStartTag() throws JspException {
		// Obtener la conexión a bd
		Connection con = MySqlDbConn.obtenerConexion();

		// Instrucción sql que seleccione a los usuarios cuyo nombre empiece con
		// una letra "" y el distrito sea ""
		String sql2 = "select * from tbusuario where distrito=? and nombre like ? ";
		try {
			// Preparamos la sententcia
			PreparedStatement pst = con.prepareStatement(sql2);
			// Pasos los parametros
			pst.setString(1, dist);
			pst.setString(2, letra + "%");
			// Ejecutamos el query
			ResultSet rs = pst.executeQuery();
			// Obtengo el stream para escribir
			JspWriter salida = pageContext.getOut();
			try {
				// Escribo la salida del tag
				salida.print("<select name=lista>");
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