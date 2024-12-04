package es.madrid.redmetro.cgf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexion {

	public Connection obtenerConexion() {
		String url = GestorFicheroConfiguracion.obtenerValor("url");
		String user = GestorFicheroConfiguracion.obtenerValor("user");
		String contra = GestorFicheroConfiguracion.obtenerValor("contra");
		Connection conex =null;
		try {
			conex = DriverManager.getConnection(url, user, contra);
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conex;
	}
}
