package es.madrid.redmetro.cgf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.madrid.redmetro.cgf.dao.ILineaDAO;
import es.madrid.redmetro.cgf.util.GestorConexion;
import es.madrid.redmetro.cgf.vo.Color;
import es.madrid.redmetro.cgf.vo.Linea;

public class LineaDaoImpl implements ILineaDAO{

	GestorConexion gC = new GestorConexion();
	
	@Override
	public List<Linea> obtenerLineas() {
		Connection conex = gC.obtenerConexion();
		String query = "SELECT * FROM t_linea";
		List<Linea> lineas = new ArrayList<>();
		ResultSet resultados = null;
		ColorDaoImpl gestorColores = new ColorDaoImpl();
		
		try(PreparedStatement pst = conex.prepareStatement(query)) {
			
			resultados = pst.executeQuery();
			while(resultados.next()) {
				Linea l = new Linea();
				l.setCod_linea(resultados.getInt(1));
				l.setNombre_corto(resultados.getString(2));
				l.setNombre_largo(resultados.getString(3));
				Color c = gestorColores.obtenerColor(resultados.getInt(4));
				l.setColor(c);
				l.setKilometros(resultados.getDouble(5));
				lineas.add(l);
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
		return lineas;
	}

	@Override
	public Linea obtenerLinea(int cod_linea) {
		List<Linea>lineas = obtenerLineas();
		Linea linea = new Linea();
		for (Linea l : lineas) {
			if (l.getCod_linea() == cod_linea) {
				linea = l;
				return linea;
			}
		}
		return null;
	}

}
