package es.madrid.redmetro.cgf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.madrid.redmetro.cgf.dao.ITrenDAO;
import es.madrid.redmetro.cgf.util.GestorConexion;
import es.madrid.redmetro.cgf.vo.Tren;

public class TrenDaoImpl implements ITrenDAO{
 
	GestorConexion gC = new GestorConexion();
	
	@Override
	public void insertarTren(Tren t) {
		Connection conexion = gC.obtenerConexion();
		String query = "INSERT INTO t_tren (cod_tren, modelo, empresa_constructora, fecha_incorporacion, cod_cochera, cod_linea) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement pst = conexion.prepareStatement(query)) {
			pst.setInt(1, t.getId());
			pst.setString(2, t.getModelo());
			pst.setString(3, t.getEmpresaConstructora());
			pst.setDate(4, t.getAnioIncorporacion());
			pst.setInt(5, t.getCodCochera());
			pst.setInt(6, t.getIdLinea());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Tren> obtenerTrenes() {
		Connection conex = gC.obtenerConexion();
		List<Tren> trenes = new ArrayList<>();
		String query = "SELECT * FROM t_tren";
		ResultSet resultados = null;
		
		try (PreparedStatement pst = conex.prepareStatement(query)) {
			resultados = pst.executeQuery();
			while (resultados.next()) {
				Tren t = new Tren();
				t.setId(resultados.getInt(1));
				t.setModelo(resultados.getString(2));
				t.setEmpresaConstructora(resultados.getString(3));
				t.setAnioIncorporacion(resultados.getDate(4));
				t.setCodCochera(resultados.getInt(5));
				t.setIdLinea(resultados.getInt(6));
				trenes.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conex != null) {
				try {
					conex.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return trenes;
	}



	
	
}
